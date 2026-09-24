package com.codingshuttle.Module1.HomeWork.customSecurityFilter;

import com.codingshuttle.Module1.HomeWork.entity.UserEntity;
import com.codingshuttle.Module1.HomeWork.service.JwtService;
import com.codingshuttle.Module1.HomeWork.service.impl.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {
    private final UserService userService;
    private final JwtService jwtService;
    private final HandlerExceptionResolver handlerExceptionResolver;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            final String tokenHeader = request.getHeader("Authorization");
            if(tokenHeader==null || !tokenHeader.startsWith("Bearer ")){
                filterChain.doFilter(request,response);
                return;
            }

            final String token = tokenHeader.split("Bearer ")[1];

            if(token!=null && SecurityContextHolder.getContext().getAuthentication()==null){
                UUID userId = jwtService.getUserIdFromToken(token);
                UserEntity userEntity = userService.getUserById(userId);
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userEntity, null, null);
                authenticationToken.setDetails((new WebAuthenticationDetailsSource().buildDetails(request)));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
            filterChain.doFilter(request,response);
        }catch(Exception e){
            handlerExceptionResolver.resolveException(request, response, null, e);
        }
    }
}
