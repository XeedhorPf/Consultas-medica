package com.ConsultasMedicas.app.controlador;

import com.ConsultasMedicas.app.entidades.*;
import com.ConsultasMedicas.app.servicio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.security.Principal;

@Controller
@RequestMapping("/administrador/usuarios")
@PreAuthorize("hasRole('ADMIN')")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("")
    public String listarUsuarios(Model model, Principal principal) {
        model.addAttribute("usuarios", usuarioService.listarTodos());
        model.addAttribute("nombreUsuario", principal.getName());
        return "administrador/usuarios/listar";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model, Principal principal) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("roles", new String[]{"ADMIN", "DOCTOR", "ASISTENTE", "FARMACEUTICO", "PACIENTE"});
        model.addAttribute("nombreUsuario", principal.getName());
        return "administrador/usuarios/formulario";
    }

    @PostMapping("/guardar")
    public String guardarUsuario(@ModelAttribute("usuario") Usuario usuario, 
            RedirectAttributes redirectAttributes) {
usuarioService.guardarUsuario(usuario);
redirectAttributes.addFlashAttribute("mensaje", "Usuario guardado correctamente");
return "redirect:/administrador/usuarios";
}

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model, Principal principal) {
        model.addAttribute("usuario", usuarioService.obtenerUsuarioPorId(id));
        model.addAttribute("roles", new String[]{"ADMIN", "DOCTOR", "ASISTENTE", "FARMACEUTICO", "PACIENTE"});
        model.addAttribute("nombreUsuario", principal.getName());
        return "administrador/usuarios/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        usuarioService.eliminarUsuario(id);
        redirectAttributes.addFlashAttribute("mensaje", "Usuario eliminado correctamente");
        return "redirect:/administrador/usuarios";
    }
}