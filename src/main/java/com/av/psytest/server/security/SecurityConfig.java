package com.av.psytest.server.security;

import com.av.psytest.server.jwt.JwtConfig;
import com.av.psytest.server.jwt.JwtTokenVerifier;
import com.av.psytest.server.jwt.JwtUsernameAndPasswordAuthFilter;
import com.av.psytest.server.services.AppUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.crypto.SecretKey;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private AppUserDetailsService appUserDetailsService;
    private SecretKey secretKey;
    private JwtConfig jwtConfig;

    @Autowired
    public SecurityConfig(AppUserDetailsService appUserDetailsService,
                          SecretKey secretKey,
                          JwtConfig jwtConfig) {
        this.appUserDetailsService = appUserDetailsService;
        this.secretKey = secretKey;
        this.jwtConfig = jwtConfig;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtUsernameAndPasswordAuthFilter(authenticationManager(),
                        jwtConfig, secretKey))
                .addFilterAfter(new JwtTokenVerifier(secretKey, jwtConfig),
                        JwtUsernameAndPasswordAuthFilter.class)
                .authorizeRequests()
                .antMatchers("/question/save").hasRole("ADMIN")
                .antMatchers("/user/**").hasRole("ADMIN")
                .antMatchers("/question/**").permitAll()
                .antMatchers("/user/reg").permitAll()
                .antMatchers("/selanswer/**").hasRole("USER")
                .antMatchers("/answer/**").hasRole("USER");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(appUserDetailsService);
        return authenticationProvider;
    }
}