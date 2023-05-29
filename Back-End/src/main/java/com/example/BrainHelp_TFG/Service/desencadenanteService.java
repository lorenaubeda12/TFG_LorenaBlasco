package com.example.BrainHelp_TFG.Service;

import com.example.BrainHelp_TFG.Repository.DesencadenanteRepository;
import com.example.BrainHelp_TFG.utils.GenericResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.example.BrainHelp_TFG.utils.Global.*;


@Service
@Transactional
public class desencadenanteService{
    private final DesencadenanteRepository desencadenanteRepository;

    public desencadenanteService(DesencadenanteRepository desencadenanteRepository) {
        this.desencadenanteRepository = desencadenanteRepository;
    }


    public GenericResponse listarDesencadenantes(){
        return  new GenericResponse(TIPO_DATA,RPTA_OK,OPERACION_CORRECTA,this.desencadenanteRepository.listarDesencadenates());

    }

    public GenericResponse miDesencadenante(int id) {
        return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, this.desencadenanteRepository.miDesencadenante(id));

    }



}
