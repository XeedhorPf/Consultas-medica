package com.ConsultasMedicas.app.controlador;

import com.ConsultasMedicas.app.entidades.*;
import com.ConsultasMedicas.app.repositorio.MedicamentoRepository;
import com.ConsultasMedicas.app.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/administrador")
@PreAuthorize("hasRole('ADMIN')")
public class AdministradorController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private MedicamentoRepository medicamentoRepository;
    @GetMapping("")
    public String verPanelAdministrador(Model model, Principal principal) {
        String nombreUsuario = principal.getName();
        long totalUsuarios = usuarioRepository.count();
        long totalMedicamentos = medicamentoRepository.count();
        List<Usuario> ultimosUsuarios = usuarioRepository.findTop5ByOrderByFechaRegistroDesc();

        model.addAttribute("nombreUsuario", nombreUsuario);
        model.addAttribute("totalUsuarios", totalUsuarios);
        model.addAttribute("totalMedicamentos", totalMedicamentos);
        model.addAttribute("ultimosUsuarios", ultimosUsuarios);
        model.addAttribute("totalMedicamentos", 0);
        model.addAttribute("nombreUsuario", principal.getName());

        return "administrador/index";
    }

    @GetMapping("/configuracion")
    public String verConfiguracion() {
        return "administrador/configuracion";
    }
    
    // Elimina el método gestionUsuarios() que causa conflicto
}