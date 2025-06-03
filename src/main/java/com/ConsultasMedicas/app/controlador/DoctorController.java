package com.ConsultasMedicas.app.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DoctorController {

    @GetMapping("/doctor")
    public String verPanelDoctor() {
        return "doctor/index";
    }
}