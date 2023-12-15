/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.csp.sentinel.dashboard.rule.nacos;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.FlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.RuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRuleProvider;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.csp.sentinel.util.StringUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.config.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hccake
 * @since 2.0.0
 */
public abstract class AbstractRuleNacosProvider<R extends RuleEntity> implements DynamicRuleProvider<List<R>> {
    private final ConfigService configService;
    private final String groupId;
    private final String dataIdPostFix;

    protected AbstractRuleNacosProvider(ConfigService configService, String groupId, String dataIdPostFix) {
        this.configService = configService;
        this.groupId = groupId;
        this.dataIdPostFix = dataIdPostFix;
    }

    @Override
    public List<R> getRules(String appName) throws Exception {
        String rules = configService.getConfig(appName + this.dataIdPostFix,
            this.groupId, 3000);
        if (StringUtil.isEmpty(rules)) {
            return new ArrayList<>();
        }
        return convertRulesFromString(rules);
    }

    protected abstract List<R> convertRulesFromString(String rules);

}
