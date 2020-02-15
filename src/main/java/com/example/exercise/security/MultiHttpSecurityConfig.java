package com.example.exercise.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class MultiHttpSecurityConfig {
    @Bean                                                             
    public UserDetailsService userDetailsService() throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        UserBuilder users = User.builder(); 
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(users.username("user").password("{noop}user").roles("USER").build());
        manager.createUser(users.username("admin").password("{noop}admin").roles("USER","ADMIN").build());
        return manager;
    }

    @Configuration
    @Order(2)                                                        
    public static class AdminWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
        protected void configure(HttpSecurity http) throws Exception {
            // HTTPS only and username and password in header        
            http.requiresChannel().anyRequest().requiresSecure()
            .and()
            .authorizeRequests()
            .antMatchers("/admin/**").hasRole("ADMIN")
            .and().addFilterAt(new AuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
            .csrf()
            .disable(); 

            http.httpBasic().disable();
        }
    }

    @Configuration
    @Order(1)                                                   
    public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.requiresChannel().anyRequest().requiresSecure()
            .and()
            .authorizeRequests()
            .antMatchers("/h2/**").hasRole("ADMIN")
            .and().formLogin()
            .and()
            .csrf()
            .disable(); 

            http.httpBasic().disable();
            http.headers().frameOptions().sameOrigin();
        }
    }
}