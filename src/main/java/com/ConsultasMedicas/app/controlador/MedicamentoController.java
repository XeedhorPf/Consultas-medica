package com.ConsultasMedicas.app.controlador;


import com.ConsultasMedicas.app.entidades.Medicamento;
import com.ConsultasMedicas.app.servicio.MedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/administrador/medicamentos")
@PreAuthorize("hasRole('ADMIN')")
public class MedicamentoController {

    @Autowired
    private MedicamentoService medicamentoService;

    @GetMapping("")
    public String listarMedicamentos(Model model) {
        model.addAttribute("medicamentos", medicamentoService.listarTodos());
        return "administrador/medicamentos/listar";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("medicamento", new Medicamento());
        return "administrador/medicamentos/formulario";
    }

    @PostMapping("/guardar")
    public String guardarMedicamento(@ModelAttribute Medicamento medicamento, RedirectAttributes redirectAttributes) {
        medicamentoService.guardarMedicamento(medicamento);
        redirectAttributes.addFlashAttribute("mensaje", "Medicamento guardado correctamente");
        return "redirect:/administrador/medicamentos";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        model.addAttribute("medicamento", medicamentoService.obtenerMedicamentoPorId(id));
        return "administrador/medicamentos/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarMedicamento(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        medicamentoService.eliminarMedicamento(id);
        redirectAttributes.addFlashAttribute("mensaje", "Medicamento eliminado correctamente");
        return "redirect:/administrador/medicamentos";
    }
}