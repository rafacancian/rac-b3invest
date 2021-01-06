package com.b3investbroker.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class RibbonConfiguration {

    @Autowired
    IClientConfig ribbonClientConfig;

    @Bean
    public static IPing ribbonPing(final IClientConfig config) {
        return new PingUrl();
    }

    @Bean
    public static IRule ribbonRule(final IClientConfig config) {
        return new WeightedResponseTimeRule();
    }
}