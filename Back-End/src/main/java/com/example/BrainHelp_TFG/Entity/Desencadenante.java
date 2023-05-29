package com.example.BrainHelp_TFG.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Desencadenante")

public class Desencadenante {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_Desencadenante;

    @Column
    private String tipo;

    public int getId_Desencadenante() {
        return id_Desencadenante;
    }

    public void setId_Desencadenante(int id_Desencadenante) {
        this.id_Desencadenante = id_Desencadenante;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
