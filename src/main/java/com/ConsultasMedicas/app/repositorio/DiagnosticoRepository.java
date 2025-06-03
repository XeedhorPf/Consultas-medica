package com.ConsultasMedicas.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ConsultasMedicas.app.entidades.Diagnostico;

public interface DiagnosticoRepository extends JpaRepository<Diagnostico, Long> {
}