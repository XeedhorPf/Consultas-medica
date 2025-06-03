package com.ConsultasMedicas.app.entidades;

import jakarta.persistence.*;

@Entity
public class Diagnostico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    @OneToOne
    private Cita cita;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Cita getCita() { return cita; }
    public void setCita(Cita cita) { this.cita = cita; }
}
