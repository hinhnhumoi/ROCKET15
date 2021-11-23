package com.vti.config.security;


import com.vti.login.JWTAuthenticationFilter;
import com.vti.login.JWTAuthorizationFilter;
import com.vti.service.IUserService;
import com.vti.service.JWTTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity

public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {


    private final IUserService userService;
    private final JWTTokenService jwtTokenService;

    public WebSecurityConfiguration(IUserService userService, JWTTokenService jwtTokenService) {
        this.userService = userService;
        this.jwtTokenService = jwtTokenService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and()
                .authorizeRequests()
                .antMatchers("/api/v1/login").anonymous()
                .antMatchers("/api/v1/groups/**").hasAnyAuthority("Manager")
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .csrf().disable()
                .addFilterBefore(new JWTAuthenticationFilter(authenticationManager(), userService, jwtTokenService),
                        UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(
                        new JWTAuthorizationFilter(jwtTokenService),
                        UsernamePasswordAuthenticationFilter.class
                );
    }
}
