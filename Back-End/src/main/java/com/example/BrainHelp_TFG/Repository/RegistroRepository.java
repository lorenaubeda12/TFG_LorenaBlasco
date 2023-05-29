package com.example.BrainHelp_TFG.Repository;


import com.example.BrainHelp_TFG.Entity.Registro;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RegistroRepository extends CrudRepository<Registro,Integer> {
    @Query("SELECT R  FROM Registro R WHERE R.id_Usuario.id_Usuario=:id")
    Iterable<Registro>listarRegistros(int id);

    @Modifying
    @Query("DELETE FROM Registro R WHERE R.id_Registro=:id")
    int borrarRegistros(@Param("id") int id);

}
