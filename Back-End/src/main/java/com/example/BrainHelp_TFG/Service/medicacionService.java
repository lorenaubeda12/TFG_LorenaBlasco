package com.example.BrainHelp_TFG.Service;


import com.example.BrainHelp_TFG.Entity.Medicacion;
import com.example.BrainHelp_TFG.Repository.MedicacionRepository;
import com.example.BrainHelp_TFG.utils.GenericResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


import static com.example.BrainHelp_TFG.utils.Global.*;

@Service
@Transactional
public class medicacionService{
    private final MedicacionRepository medicacionRepository ;

    public medicacionService(MedicacionRepository medicacionRepository) {
        this.medicacionRepository = medicacionRepository;
    }


    public GenericResponse listarMedicamentos(){
        return  new GenericResponse(TIPO_DATA,RPTA_OK,OPERACION_CORRECTA,this.medicacionRepository.listarMedicamentos());

    }

    public GenericResponse miMedicacion(int id) {
        return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, this.medicacionRepository.medicacionElegida(id));

    }

    public GenericResponse guardarMedicamento(Medicacion m) {
        Optional<Medicacion> optM = this.medicacionRepository.findByNombre(m.getTipoMedicacion());
        if (optM.isPresent()) {
            return new GenericResponse(TIPO_DATA, RPTA_OK, "Este medicamento ya existe en la base de datos", optM.get());
        } else {
            return new GenericResponse(TIPO_DATA, RPTA_OK, "Medicamento añadido correctamente", this.medicacionRepository.save(m));
        }
    }


}
