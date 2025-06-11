package com.consultaMedica.security;

import com.consultaMedica.repositories.PacienteRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    private final TokenService tokenService;
    private final PacienteRepository pacienteRepository;

    public SecurityFilter(TokenService tokenService, PacienteRepository pacienteRepository) {
        this.tokenService = tokenService;
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = this.recuperarToken(request);
        if(token != null){
           String login = tokenService.validateToken(token);
           UserDetails paciente = pacienteRepository.findByNome(login);

            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(paciente, null, paciente.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request,response);  //CHAMANDO O PRÓXIMO FILTRO
    }

    public String recuperarToken(HttpServletRequest request){
        String authHeader = request.getHeader("Authorization");
        if(authHeader == null) return null;
        return authHeader.replace("Bearer ", "");
    }
}
