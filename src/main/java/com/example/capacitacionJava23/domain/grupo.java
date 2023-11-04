package com.example.capacitacionJava23.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "grupo")
public class grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombregrupo", nullable = false)
    private String nombregrupo;


    @Column(name = "detallegrupo", nullable = false)
    private String detallegrupo;

    @OneToMany(mappedBy = "grupo")
    private List<Tarea> tareas;

    // Getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombregrupo() {
        return nombregrupo;
    }

    public void setNombregrupo(String nombregrupo) {
        this.nombregrupo = nombregrupo;
    }

    public String getDetallegrupo() {
        return detallegrupo;
    }

    public void setDetallegrupo(String detallegrupo) {
        this.detallegrupo = detallegrupo;
    }
}


