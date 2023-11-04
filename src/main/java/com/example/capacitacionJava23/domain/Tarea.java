
package com.example.capacitacionJava23.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tarea")
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombretarea", nullable = false)
    private String nombreTarea;

    @Column(name = "fechacreacion", nullable = false)
    private LocalDate  fechaCreacion;

    @Column(name = "fechavencimiento", nullable = false)
    private LocalDate  fechaVencimiento;

    @ManyToOne
    @JoinColumn(name = "idgrupo", nullable = false)
    private grupo grupo;

    // Getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreTarea() {
        return nombreTarea;
    }

    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }

    public LocalDate  getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate  fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDate  getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate  fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public com.example.capacitacionJava23.domain.grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(com.example.capacitacionJava23.domain.grupo grupo) {
        this.grupo = grupo;
    }
}
