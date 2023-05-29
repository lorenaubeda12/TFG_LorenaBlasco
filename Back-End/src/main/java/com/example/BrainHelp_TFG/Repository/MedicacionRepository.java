package com.example.BrainHelp_TFG.Repository;


import com.example.BrainHelp_TFG.Entity.Medicacion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MedicacionRepository extends CrudRepository<Medicacion,Integer> {

    @Query("SELECT M FROM Medicacion M")
    Iterable<Medicacion>listarMedicamentos();

    @Query("SELECT M FROM Medicacion M WHERE M.id_Medicacion=:id")
    Iterable<Medicacion>medicacionElegida(int id);
    @Query("Select M FROM Medicacion  M WHERE M.tipoMedicacion=:nombre")
    Optional<Medicacion> findByNombre(String nombre);
}
