package com.example.BrainHelp_TFG.Service;





import com.example.BrainHelp_TFG.Entity.Cita;
import com.example.BrainHelp_TFG.Repository.CitaRepository;
import com.example.BrainHelp_TFG.utils.GenericResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.example.BrainHelp_TFG.utils.Global.*;

import static com.example.BrainHelp_TFG.utils.Global.RPTA_OK;


@Service
@Transactional
public class citaService{
    private final CitaRepository citasRepository;

    public citaService(CitaRepository citasRepository) {
        this.citasRepository = citasRepository;
    }


    public GenericResponse listarCitas(int id){
        return  new GenericResponse(TIPO_DATA,RPTA_OK,OPERACION_CORRECTA,this.citasRepository.listarCitas(id));

    }
    public GenericResponse guardarCita(Cita cita) {
        return new GenericResponse(TIPO_DATA, RPTA_OK, "Cita añadida", citasRepository.save(cita));
    }
    public GenericResponse borrarCita (int id) {
        int deletedCount = citasRepository.borrarCitas(id);
        return new GenericResponse(TIPO_DATA, RPTA_OK, "Cita borrada", deletedCount);
    }

}