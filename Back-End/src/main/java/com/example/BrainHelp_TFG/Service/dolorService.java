package com.example.BrainHelp_TFG.Service;


import com.example.BrainHelp_TFG.Repository.DolorRepository;
import com.example.BrainHelp_TFG.utils.GenericResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import static com.example.BrainHelp_TFG.utils.Global.*;

@Service
@Transactional
public class dolorService {
    private final DolorRepository dolorRepository;

    public dolorService(DolorRepository dolorRepository) {
        this.dolorRepository = dolorRepository;
    }


    public GenericResponse listarDolores() {
        return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, this.dolorRepository.listarDolores());

    }
    public GenericResponse miDolor(int id) {
        return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, this.dolorRepository.listarDolorSufrido(id));

    }

}
