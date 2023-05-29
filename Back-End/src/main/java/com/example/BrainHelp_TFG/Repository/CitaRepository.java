package com.example.BrainHelp_TFG.Repository;


import com.example.BrainHelp_TFG.Entity.Cita;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CitaRepository extends CrudRepository<Cita,Integer> {
    @Query("SELECT C  FROM Cita C WHERE C.id_Usuario.id_Usuario=:id")
    Iterable<Cita>listarCitas(int id);

    @Modifying
    @Query("DELETE FROM Cita C WHERE C.id_Cita=:id")
    int borrarCitas(@Param("id") int id);



}
