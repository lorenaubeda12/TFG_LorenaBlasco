package com.example.BrainHelp_TFG.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Nivel")
public class Nivel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_Nivel;
    @Column
    private int  puntos;
    @Column
    private String tipo;

    public Nivel() {
    }

    public int getId_Nivel() {
        return id_Nivel;
    }

    public void setId_Nivel(int id_Nivel) {
        this.id_Nivel = id_Nivel;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
