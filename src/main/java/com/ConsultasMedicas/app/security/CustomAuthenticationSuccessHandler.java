package com.ConsultasMedicas.app.security;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication
    ) throws IOException {
        
        for (GrantedAuthority authority : authentication.getAuthorities()) {
            String role = authority.getAuthority();
            
            switch (role) {
                case "ROLE_ADMIN":
                    response.sendRedirect("/administrador");
                    return;
                case "ROLE_DOCTOR":
                    response.sendRedirect("/doctor");
                    return;
                case "ROLE_ASISTENTE":
                    response.sendRedirect("/asistente");
                    return;
                case "ROLE_FARMACEUTICO":
                    response.sendRedirect("/farmaceutico");
                    return;
                case "ROLE_PACIENTE":
                    response.sendRedirect("/paciente");
                    return;
            }
        }
        
        throw new IllegalStateException("Usuario sin rol asignado");
    }
}