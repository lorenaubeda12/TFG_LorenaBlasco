package com.example.BrainHelp_TFG.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Dolor")

public class Dolor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_Dolor;

    @Column
    private String tipo;

    public int getId_Dolor() {
        return id_Dolor;
    }

    public void setId_Dolor(int id_Dolor) {
        this.id_Dolor = id_Dolor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
