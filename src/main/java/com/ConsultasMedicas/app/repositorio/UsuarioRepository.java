package com.ConsultasMedicas.app.repositorio;

import com.ConsultasMedicas.app.entidades.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCorreo(String correo);
    
    @Query("SELECT u FROM Usuario u ORDER BY u.fechaRegistro DESC LIMIT 5")
    List<Usuario> findTop5ByOrderByFechaRegistroDesc();
    
    List<Usuario> findByRol(String rol);
}


