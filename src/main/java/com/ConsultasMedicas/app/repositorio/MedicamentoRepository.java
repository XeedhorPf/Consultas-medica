package com.ConsultasMedicas.app.repositorio;

import com.ConsultasMedicas.app.entidades.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {
}