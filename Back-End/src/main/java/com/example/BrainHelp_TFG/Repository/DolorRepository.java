package com.example.BrainHelp_TFG.Repository;


import com.example.BrainHelp_TFG.Entity.Dolor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DolorRepository extends CrudRepository<Dolor,Integer> {
    @Query("SELECT Do FROM Dolor Do")
    Iterable<Dolor>listarDolores();

    @Query("SELECT Do FROM Dolor Do WHERE Do.id_Dolor=:id")
    Iterable<Dolor>listarDolorSufrido(int id);

}
