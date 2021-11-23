package com.vti.login;

import com.vti.service.IUserService;
import com.vti.service.JWTTokenService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class JWTAuthenticationFilter extends AbstractAuthenticationProcessingFilter {


    private final IUserService userService;
    private final JWTTokenService jwtTokenService;

    public JWTAuthenticationFilter(AuthenticationManager authManager,IUserService userService, JWTTokenService jwtTokenService) {
        super(new AntPathRequestMatcher("/api/v1/login"));
        setAuthenticationManager(authManager);
        this.userService = userService;
        this.jwtTokenService = jwtTokenService;
    }

    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest request,
            HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = userService.getUserByUsername(username).getRole();

        return getAuthenticationManager().authenticate(
                new UsernamePasswordAuthenticationToken(
                        username,
                        password,
                        AuthorityUtils.createAuthorityList(role)
                )
        );
    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain,
            Authentication authResult) {
        jwtTokenService.addJWTTokenToHeader(response, authResult.getName());
    }
}
