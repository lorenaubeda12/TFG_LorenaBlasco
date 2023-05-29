package com.example.BrainHelp_TFG.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "Medicacion")
public class Medicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_Medicacion;
    @Column
private String tipoMedicacion;
    @Column
    private int  gramaje;

    public int getId_Medicacion() {
        return id_Medicacion;
    }

    public void setId_Medicacion(int id_Medicacion) {
        this.id_Medicacion = id_Medicacion;
    }

    public String getTipoMedicacion() {
        return tipoMedicacion;
    }

    public void setTipoMedicacion(String tipoMedicacion) {
        this.tipoMedicacion = tipoMedicacion;
    }

    public int getGramaje() {
        return gramaje;
    }

    public void setGramaje(int gramaje) {
        this.gramaje = gramaje;
    }
}
