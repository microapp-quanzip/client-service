package com.viettel.project.security;

import org.springframework.cloud.commons.security.ResourceServerTokenRelayAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Configuration
@SuppressWarnings(value = "deprecation")
@EnableResourceServer
public class ResourceServerSecurityConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(getTokenStore());
    }

    @Bean
    public TokenStore getTokenStore(){
        return new JwtTokenStore(getJwtTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter getJwtTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        String verifyKey = "";

        try {
            InputStreamReader inputStreamReader = new InputStreamReader(
                    new ClassPathResource("publickey.txt").getInputStream());
            BufferedReader reader = new BufferedReader(inputStreamReader);
            verifyKey = reader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        converter.setVerifierKey(verifyKey);
        return converter;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/actuator/**", "/v3/api-docs/**", "/swagger-ui/**").permitAll();
    }
}
