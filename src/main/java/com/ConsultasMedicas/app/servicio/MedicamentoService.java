package com.ConsultasMedicas.app.servicio;


import com.ConsultasMedicas.app.entidades.Medicamento;
import com.ConsultasMedicas.app.repositorio.MedicamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MedicamentoService {
    @Autowired
    private MedicamentoRepository medicamentoRepository;

    public List<Medicamento> listarTodos() {
        return medicamentoRepository.findAll();
    }

    public Medicamento guardarMedicamento(Medicamento medicamento) {
        return medicamentoRepository.save(medicamento);
    }

    public Medicamento obtenerMedicamentoPorId(Long id) {
        return medicamentoRepository.findById(id).orElse(null);
    }

    public void eliminarMedicamento(Long id) {
        medicamentoRepository.deleteById(id);
    }
}
