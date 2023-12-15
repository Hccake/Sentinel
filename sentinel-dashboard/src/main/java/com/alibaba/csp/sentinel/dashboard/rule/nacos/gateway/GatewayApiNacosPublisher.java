package com.alibaba.csp.sentinel.dashboard.rule.nacos.gateway;

import com.alibaba.csp.sentinel.dashboard.config.NacosProperties;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.gateway.ApiDefinitionEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.gateway.GatewayFlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.AbstractRuleNacosPublisher;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosConfigConstants;
import com.alibaba.nacos.api.config.ConfigService;
import org.springframework.stereotype.Component;

/**
 * @author Hccake
 */
@Component("gatewayApiDefinitionNacosPublisher")
public class GatewayApiNacosPublisher extends AbstractRuleNacosPublisher<ApiDefinitionEntity> {
    protected GatewayApiNacosPublisher(ConfigService configService, NacosProperties nacosProperties) {
        super(configService, nacosProperties.getGroupId(), NacosConfigConstants.GATEWAY_API_DATA_ID_POSTFIX);
    }
}
