package com.alibaba.csp.sentinel.dashboard.rule.nacos.degrade;

import com.alibaba.csp.sentinel.dashboard.config.NacosProperties;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.DegradeRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.AbstractRuleNacosProvider;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosConfigConstants;
import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.config.ConfigService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Hccake
 */
@Component("degradeRuleNacosProvider")
public class DegradeRuleNacosProvider extends AbstractRuleNacosProvider<DegradeRuleEntity> {
    protected DegradeRuleNacosProvider(ConfigService configService, NacosProperties nacosProperties) {
        super(configService, nacosProperties.getGroupId(), NacosConfigConstants.DEGRADE_DATA_ID_POSTFIX);
    }

    @Override
    public List<DegradeRuleEntity> convertRulesFromString(String rules) {
        return JSON.parseArray(rules, DegradeRuleEntity.class);
    }
}
