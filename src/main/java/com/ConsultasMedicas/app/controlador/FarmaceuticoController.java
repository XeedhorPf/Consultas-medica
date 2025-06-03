package com.ConsultasMedicas.app.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FarmaceuticoController {

    @GetMapping("/farmaceutico")
    public String verPanelFarmaceutico() {
        return "farmaceutico/index";
    }
}