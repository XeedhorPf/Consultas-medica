package com.ConsultasMedicas.app.controlador;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ch.qos.logback.core.model.Model;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        return "login";
    }
}