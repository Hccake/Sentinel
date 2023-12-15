package com.alibaba.csp.sentinel.dashboard.rule.nacos.flow;

import com.alibaba.csp.sentinel.dashboard.config.NacosProperties;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.FlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.AbstractRuleNacosProvider;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosConfigConstants;
import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.config.ConfigService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Hccake
 */
@Component("flowRuleNacosProvider")
public class FlowRuleNacosProvider extends AbstractRuleNacosProvider<FlowRuleEntity> {
    protected FlowRuleNacosProvider(ConfigService configService, NacosProperties nacosProperties) {
        super(configService, nacosProperties.getGroupId(), NacosConfigConstants.FLOW_DATA_ID_POSTFIX);
    }

    @Override
    public List<FlowRuleEntity> convertRulesFromString(String rules) {
        return JSON.parseArray(rules, FlowRuleEntity.class);
    }
}
