package com.alibaba.csp.sentinel.dashboard.rule.nacos.param;

import com.alibaba.csp.sentinel.dashboard.config.NacosProperties;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.ParamFlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.AbstractRuleNacosPublisher;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosConfigConstants;
import com.alibaba.nacos.api.config.ConfigService;
import org.springframework.stereotype.Component;

/**
 * @author Hccake
 */
@Component("paramFlowRuleNacosPublisher")
public class ParamFlowRuleNacosPublisher extends AbstractRuleNacosPublisher<ParamFlowRuleEntity> {
    protected ParamFlowRuleNacosPublisher(ConfigService configService, NacosProperties nacosProperties) {
        super(configService, nacosProperties.getGroupId(), NacosConfigConstants.PARAM_FLOW_DATA_ID_POSTFIX);
    }
}
