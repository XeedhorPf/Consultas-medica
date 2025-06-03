package com.ConsultasMedicas.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ConsultasMedicas.app.entidades.Receta;

public interface RecetaRepository extends JpaRepository<Receta, Long> {
}