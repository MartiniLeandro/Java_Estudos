package com.treinoSecurity.config;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.treinoSecurity.Repositories.AppUserRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    private TokenService tokenService;
    private AppUserRepository appUserRepository;

    public SecurityFilter(TokenService tokenService, AppUserRepository appUserRepository) {
        this.tokenService = tokenService;
        this.appUserRepository = appUserRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = this.recuperarToken(request);
        if(token != null){
            String login = tokenService.validateToken(token);
            UserDetails user = appUserRepository.findByEmail(login);

            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user,null , user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }

    private String recuperarToken(HttpServletRequest request){
        String tokenHeader = request.getHeader("Authorization");
        if(tokenHeader == null) return null;
        return tokenHeader.replace("Bearer ", "");
    }
    
}
