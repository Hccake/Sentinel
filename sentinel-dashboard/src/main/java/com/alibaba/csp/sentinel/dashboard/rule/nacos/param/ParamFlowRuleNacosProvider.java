package com.alibaba.csp.sentinel.dashboard.rule.nacos.param;

import com.alibaba.csp.sentinel.dashboard.config.NacosProperties;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.ParamFlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.AbstractRuleNacosProvider;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosConfigConstants;
import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.config.ConfigService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Hccake
 */
@Component("paramFlowRuleNacosProvider")
public class ParamFlowRuleNacosProvider extends AbstractRuleNacosProvider<ParamFlowRuleEntity> {
    protected ParamFlowRuleNacosProvider(ConfigService configService, NacosProperties nacosProperties) {
        super(configService, nacosProperties.getGroupId(), NacosConfigConstants.PARAM_FLOW_DATA_ID_POSTFIX);
    }

    @Override
    public List<ParamFlowRuleEntity> convertRulesFromString(String rules) {
        return JSON.parseArray(rules, ParamFlowRuleEntity.class);
    }
}
