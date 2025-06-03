package com.ConsultasMedicas.app.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AsistenteController {

    @GetMapping("/asistente")
    public String verPanelAsistente() {
        return "asistente/index";
    }
}