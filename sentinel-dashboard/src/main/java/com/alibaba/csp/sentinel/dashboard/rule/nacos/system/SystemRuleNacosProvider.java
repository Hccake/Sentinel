package com.alibaba.csp.sentinel.dashboard.rule.nacos.system;

import com.alibaba.csp.sentinel.dashboard.config.NacosProperties;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.SystemRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.AbstractRuleNacosProvider;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosConfigConstants;
import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.config.ConfigService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Hccake
 */
@Component("systemRuleNacosProvider")
public class SystemRuleNacosProvider extends AbstractRuleNacosProvider<SystemRuleEntity> {
    protected SystemRuleNacosProvider(ConfigService configService, NacosProperties nacosProperties) {
        super(configService, nacosProperties.getGroupId(), NacosConfigConstants.SYSTEM_DATA_ID_POSTFIX);
    }

    @Override
    public List<SystemRuleEntity> convertRulesFromString(String rules) {
        return JSON.parseArray(rules, SystemRuleEntity.class);
    }
}
