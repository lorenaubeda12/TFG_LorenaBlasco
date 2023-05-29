package com.example.BrainHelp_TFG.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;


import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "Registro")
public class Registro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_Registro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Usuario", referencedColumnName = "id_Usuario")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Usuario id_Usuario;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Medicacion", referencedColumnName = "id_Medicacion")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Medicacion id_Medicacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Desencadenante", referencedColumnName = "id_Desencadenante")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Desencadenante id_Desencadenante;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Dolor", referencedColumnName = "id_Dolor")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Dolor  id_Dolor;

    @Column
    private String intensidad;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column
    private Date fechaRegistro;
    @Column
    private int duracionCrisis;



    public Usuario getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(Usuario id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public String getIntensidad() {
        return intensidad;
    }

    public void setIntensidad(String intensidad) {
        this.intensidad = intensidad;
    }

    public int getId_Registro() {
        return id_Registro;
    }

    public void setId_Registro(int id_Registro) {
        this.id_Registro = id_Registro;
    }

    public Medicacion getId_Medicacion() {
        return id_Medicacion;
    }

    public void setId_Medicacion(Medicacion id_Medicacion) {
        this.id_Medicacion = id_Medicacion;
    }

    public Desencadenante getId_Desencadenante() {
        return id_Desencadenante;
    }

    public void setId_Desencadenante(Desencadenante id_Desencadenante) {
        this.id_Desencadenante = id_Desencadenante;
    }

    public Dolor getId_Dolor() {
        return id_Dolor;
    }

    public void setId_Dolor(Dolor id_Dolor) {
        this.id_Dolor = id_Dolor;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getDuracionCrisis() {
        return duracionCrisis;
    }

    public void setDuracionCrisis(int duracionCrisis) {
        this.duracionCrisis = duracionCrisis;
    }
}

