package com.example.hotelapi.config;

import com.example.hotelapi.security.JwtAuthorizationFilter;
import com.example.hotelapi.security.JwtProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtProvider provider;

    public WebSecurityConfig(JwtProvider provider) {
        this.provider = provider;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        // h2 console
        http.headers()
                .frameOptions()
                .disable();

//        http.httpBasic();
        http.addFilterBefore(new JwtAuthorizationFilter(provider), UsernamePasswordAuthenticationFilter.class);

        // pas de cookies
        http.sessionManagement().sessionCreationPolicy( SessionCreationPolicy.STATELESS );

        http.authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .antMatchers(HttpMethod.POST,"/reserv/request").hasAuthority("CLIENT")
                .antMatchers("/client/test").authenticated()
                .anyRequest().permitAll();
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }



}
