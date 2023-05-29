package com.example.BrainHelp_TFG.Repository;


import com.example.BrainHelp_TFG.Entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioRepository  extends CrudRepository<Usuario,Integer> {
    @Query("SELECT U FROM Usuario U WHERE U.email=:correo AND U.contrasena=:password")
    Optional<Usuario> login(String correo, String password);


    @Query("SELECT COUNT(U.id_Usuario) > 0 FROM Usuario U WHERE U.email=:email")
    boolean existByEmail(String email);

    @Query("SELECT U FROM Usuario U WHERE U.id_Usuario=:id")
    Optional<Usuario>listarDatos(int id);

}

