package com.example.BrainHelp_TFG.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Cita")
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_Cita;
    @Column
    @JsonFormat(pattern="yyyy-MM-dd", timezone="Europe/Madrid")
    private Date fecha;
    @Column
    private String lugar;
    @Column
    private Boolean activo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Usuario", referencedColumnName = "id_Usuario")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Usuario  id_Usuario;
    @Column
    private String hora;
    @Column
    private String razonCita;
    @Column
    private String medico;

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getRazonCita() {
        return razonCita;
    }

    public void setRazonCita(String razonCita) {
        this.razonCita = razonCita;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public int getId_Cita() {
        return id_Cita;
    }

    public void setId_Cita(int ID_Cita) {
        this.id_Cita = ID_Cita;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Usuario getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(Usuario id_Usuario) {
        this.id_Usuario = id_Usuario;
    }
}
