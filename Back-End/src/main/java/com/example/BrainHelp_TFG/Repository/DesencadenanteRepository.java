package com.example.BrainHelp_TFG.Repository;

import com.example.BrainHelp_TFG.Entity.Desencadenante;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DesencadenanteRepository extends CrudRepository<Desencadenante,Integer> {
    @Query("SELECT De FROM Desencadenante De")
    Iterable<Desencadenante>listarDesencadenates();
    @Query("SELECT De FROM Desencadenante De where De.id_Desencadenante=:id")
    Iterable<Desencadenante>miDesencadenante(int id);
}
