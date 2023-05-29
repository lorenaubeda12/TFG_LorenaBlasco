package com.example.BrainHelp_TFG.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

import java.sql.Date;


@Entity
@Table(name = "Usuario")

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_Usuario;
    @Column
    private String nombreUsuario;
    @Column
    private String apellidosUsuario;
    @Column
    private String email;
    @Column
    private boolean Activo;
    @Column
    @JsonFormat(pattern="yyyy-MM-dd", timezone="Europe/Madrid")
    private Date fechaNacimiento;
    @Column
    private String contrasena;
    @Column
    private String numTarjeta;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Nivel", referencedColumnName = "id_Nivel")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Nivel id_Nivel;
    @Column
    private String userName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Membresia", referencedColumnName = "id_Membresia")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Membresia id_Membresia;

    public int getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(int ID_Usuario) {
        this.id_Usuario = ID_Usuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidosUsuario() {
        return apellidosUsuario;
    }

    public void setApellidosUsuario(String apellidosUsuario) {
        this.apellidosUsuario = apellidosUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActivo() {
        return Activo;
    }

    public void setActivo(boolean activo) {
        Activo = activo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public Nivel getId_Nivel() {
        return id_Nivel;
    }

    public void setId_Nivel(Nivel id_Nivel) {
        this.id_Nivel = id_Nivel;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Membresia getId_Membresia() {
        return id_Membresia;
    }

    public void setId_Membresia(Membresia id_Membresia) {
        this.id_Membresia = id_Membresia;
    }
}

