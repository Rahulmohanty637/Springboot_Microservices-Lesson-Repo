package com.cipherwiz.Spring.Security.Demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // When you want to change something you need to return an object of SercurityFilterchain, that
    // means we have to create a bean which will return SecurityFilterChain object
    // So entire Spring security behind the scenes works with this spring SecurityFilterChain using HttpSecurity
    @Bean
    public SecurityFilterChain securityFilterChain(){

    }
}
