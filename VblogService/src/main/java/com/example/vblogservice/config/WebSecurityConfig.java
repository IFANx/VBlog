package com.example.vblogservice.config;


import com.example.vblogservice.filter.JwtAuthenticationFilter;
import com.example.vblogservice.filter.JwtLoginFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests()
                .antMatchers(HttpMethod.POST, "/register").permitAll()
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(new JwtLoginFilter("/login", authentication -> {
                            return authentication;
                        }),
                        UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JwtLoginFilter("/register", authentication -> {
                            return authentication;
                        }),
                        UsernamePasswordAuthenticationFilter.class)
                .addFilterAfter(new JwtAuthenticationFilter(),
                        UsernamePasswordAuthenticationFilter.class);
    }

}
