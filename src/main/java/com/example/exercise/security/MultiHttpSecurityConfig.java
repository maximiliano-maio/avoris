package com.example.exercise.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class MultiHttpSecurityConfig {

    @Configuration
    public static class AdminWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.httpBasic()
                .and().authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/**").permitAll()    
                .antMatchers(HttpMethod.POST,"/admin/**").permitAll()
                .antMatchers(HttpMethod.GET, "/h2/**").denyAll()
                .and()
                    .csrf().disable()
                    .formLogin().disable();
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
        }
    }

}