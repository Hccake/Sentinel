package com.alibaba.csp.sentinel.dashboard.rule.nacos.authority;

import com.alibaba.csp.sentinel.dashboard.config.NacosProperties;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.AuthorityRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.AbstractRuleNacosProvider;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosConfigConstants;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityRule;
import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.config.ConfigService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Hccake
 */
@Component("authorityRuleNacosProvider")
public class AuthorityRuleNacosProvider extends AbstractRuleNacosProvider<AuthorityRuleEntity> {
    protected AuthorityRuleNacosProvider(ConfigService configService, NacosProperties nacosProperties) {
        super(configService, nacosProperties.getGroupId(), NacosConfigConstants.AUTHORITY_DATA_ID_POSTFIX);
    }
    @Override
    public List<AuthorityRuleEntity> convertRulesFromString(String rules) {
        return JSON.parseArray(rules, AuthorityRuleEntity.class);
    }
}
