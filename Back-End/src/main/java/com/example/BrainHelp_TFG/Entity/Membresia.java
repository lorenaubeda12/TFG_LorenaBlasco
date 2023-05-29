package com.example.BrainHelp_TFG.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Membresia")

public class Membresia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_Membresia;
    @Column
    private double precio;
    @Column
    private boolean activa;
    @Column
    private String tipo;

    public int getId_Membresia() {
        return id_Membresia;
    }

    public void setId_Membresia(int id_Membresia) {
        this.id_Membresia = id_Membresia;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
