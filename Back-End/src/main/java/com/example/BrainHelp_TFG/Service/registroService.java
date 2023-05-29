package com.example.BrainHelp_TFG.Service;


import com.example.BrainHelp_TFG.Entity.Registro;
import com.example.BrainHelp_TFG.Repository.RegistroRepository;
import com.example.BrainHelp_TFG.utils.GenericResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.example.BrainHelp_TFG.utils.Global.*;


@Service
@Transactional
public class registroService {
    private final RegistroRepository registroRepository;

    public registroService(RegistroRepository registroRepository) {
        this.registroRepository = registroRepository;
    }

    public GenericResponse listarRegistros(int id){
        return  new GenericResponse(TIPO_DATA,RPTA_OK,OPERACION_CORRECTA,this.registroRepository.listarRegistros(id));

    }

    public GenericResponse save(Registro r) {
        return new GenericResponse(TIPO_DATA, RPTA_OK, "Usuario registrado correctamente", this.registroRepository.save(r));
    }

    public GenericResponse borrarRegistro (int id) {
        int deletedCount = registroRepository.borrarRegistros(id);
        return new GenericResponse(TIPO_DATA, RPTA_OK, "Cita borrada", deletedCount);
    }
}