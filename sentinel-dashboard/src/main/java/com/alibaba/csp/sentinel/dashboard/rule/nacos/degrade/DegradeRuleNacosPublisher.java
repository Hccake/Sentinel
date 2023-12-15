package com.alibaba.csp.sentinel.dashboard.rule.nacos.degrade;

import com.alibaba.csp.sentinel.dashboard.config.NacosProperties;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.DegradeRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.AbstractRuleNacosPublisher;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosConfigConstants;
import com.alibaba.nacos.api.config.ConfigService;
import org.springframework.stereotype.Component;

/**
 * @author Hccake
 */
@Component("degradeRuleNacosPublisher")
public class DegradeRuleNacosPublisher extends AbstractRuleNacosPublisher<DegradeRuleEntity> {
    protected DegradeRuleNacosPublisher(ConfigService configService, NacosProperties nacosProperties) {
        super(configService, nacosProperties.getGroupId(), NacosConfigConstants.DEGRADE_DATA_ID_POSTFIX);
    }
}
