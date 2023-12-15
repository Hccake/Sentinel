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

import com.alibaba.csp.sentinel.dashboard.rule.DynamicRulePublisher;
import com.alibaba.csp.sentinel.util.AssertUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.config.ConfigService;

import java.util.List;

/**
 * @author Hccake
 * @since 2.0.0
 */
public abstract class AbstractRuleNacosPublisher<R> implements DynamicRulePublisher<List<R>> {
    private final ConfigService configService;
    private final String groupId;
    private final String dataIdPostFix;

    protected AbstractRuleNacosPublisher(ConfigService configService, String groupId, String dataIdPostFix) {
        this.configService = configService;
        this.groupId = groupId;
        this.dataIdPostFix = dataIdPostFix;
    }

    @Override
    public void publish(String app, List<R> rules) throws Exception {
        AssertUtil.notEmpty(app, "app name cannot be empty");
        if (rules == null) {
            return;
        }
        configService.publishConfig(app + this.dataIdPostFix, this.groupId, convertRulesToString(rules));
    }

    protected String convertRulesToString(List<R> rules) {
        return JSON.toJSONString(rules);
    }

}
