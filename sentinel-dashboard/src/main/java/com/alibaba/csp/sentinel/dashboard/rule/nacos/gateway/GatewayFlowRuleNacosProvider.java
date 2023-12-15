package com.alibaba.csp.sentinel.dashboard.rule.nacos.gateway;

import com.alibaba.csp.sentinel.dashboard.config.NacosProperties;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.gateway.GatewayFlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.AbstractRuleNacosProvider;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosConfigConstants;
import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.config.ConfigService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Hccake
 */
@Component("gatewayFlowRuleNacosProvider")
public class GatewayFlowRuleNacosProvider extends AbstractRuleNacosProvider<GatewayFlowRuleEntity> {
    protected GatewayFlowRuleNacosProvider(ConfigService configService, NacosProperties nacosProperties) {
        super(configService, nacosProperties.getGroupId(), NacosConfigConstants.GATEWAY_FLOW_DATA_ID_POSTFIX);
    }

    @Override
    public List<GatewayFlowRuleEntity> convertRulesFromString(String rules) {
        return JSON.parseArray(rules, GatewayFlowRuleEntity.class);
    }
}
