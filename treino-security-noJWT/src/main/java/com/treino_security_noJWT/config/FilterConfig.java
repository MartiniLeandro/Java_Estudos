package com.treino_security_noJWT.config;

import com.treino_security_noJWT.repositories.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.security.Security;

@Component
public class FilterConfig extends OncePerRequestFilter {

    private final TokenService tokenService;
    private final UserRepository userRepository;

    public FilterConfig(TokenService tokenService, UserRepository userRepository){
        this.tokenService = tokenService;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = recuperarToken(request);
        if(token != null){
            String login = tokenService.validateToken(token);
            UserDetails user = userRepository.findByLogin(login);

            UsernamePasswordAuthenticationToken userPassword = UsernamePasswordAuthenticationToken.authenticated(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(userPassword);
        }
        filterChain.doFilter(request,response);
    }

    public String recuperarToken(HttpServletRequest request){
        String authHeader = request.getHeader("Authentication");
        if(authHeader == null) return null;
        return authHeader.replace("Bearer ",  "");
    }
}
