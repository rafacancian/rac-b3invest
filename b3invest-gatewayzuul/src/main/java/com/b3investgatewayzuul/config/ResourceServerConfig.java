package com.b3investgatewayzuul.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Slf4j
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private JwtTokenStore tokenStore;

    private static final String[] PUBLIC = {"/b3invest-oauth/oauth/token", "/b3invest-manager/h2-console/**"};

    private static final String[] OPERATOR = {"/b3invest-broker/**"};

    private static final String[] ADMIN = {"/b3invest-manager/**", "/b3invest-user/**", "/b3invest-oauth/users/**", "/actuator/**", "/b3invest-manager/actuator/**"};

    @Override
    public void configure(final ResourceServerSecurityConfigurer resources) throws Exception {
        log.info("ResourceServerConfig configure: {}", resources);
        resources.tokenStore(tokenStore);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers(PUBLIC).permitAll()
                .antMatchers(HttpMethod.GET, OPERATOR).hasAnyRole("OPERATOR", "ADMIN")
                .antMatchers(ADMIN).hasRole("ADMIN")
                .anyRequest().authenticated();

        http.cors().configurationSource(corsConfigurationSource());
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        log.info("ResourceServerConfig corsConfigurationSource");
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.setAllowedOrigins(Arrays.asList("*"));
        corsConfig.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "PATCH"));
        corsConfig.setAllowCredentials(true);
        corsConfig.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);
        log.info("ResourceServerConfig corsConfigurationSource: {}", source);
        return source;
    }

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        log.info("ResourceServerConfig corsFilter");
        FilterRegistrationBean<CorsFilter> bean
                = new FilterRegistrationBean<>(new CorsFilter(corsConfigurationSource()));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }

}
