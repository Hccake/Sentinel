package com.alibaba.csp.sentinel.dashboard.rule.nacos.authority;

import com.alibaba.csp.sentinel.dashboard.config.NacosProperties;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.AuthorityRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.AbstractRuleNacosPublisher;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosConfigConstants;
import com.alibaba.nacos.api.config.ConfigService;
import org.springframework.stereotype.Component;

/**
 * @author Hccake
 */
@Component("authorityRuleNacosPublisher")
public class AuthorityRuleNacosPublisher extends AbstractRuleNacosPublisher<AuthorityRuleEntity> {
    protected AuthorityRuleNacosPublisher(ConfigService configService, NacosProperties nacosProperties) {
        super(configService, nacosProperties.getGroupId(), NacosConfigConstants.AUTHORITY_DATA_ID_POSTFIX);
    }
}
