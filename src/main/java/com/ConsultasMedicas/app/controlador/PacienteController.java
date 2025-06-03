package com.ConsultasMedicas.app.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PacienteController {

    @GetMapping("/paciente")
    public String verPanelPaciente() {
        return "paciente/index";
    }
}