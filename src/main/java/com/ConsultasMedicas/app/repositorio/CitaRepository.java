package com.ConsultasMedicas.app.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import com.ConsultasMedicas.app.entidades.Cita;

public interface CitaRepository extends JpaRepository<Cita, Long> {
}