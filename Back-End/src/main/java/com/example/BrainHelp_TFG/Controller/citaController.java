package com.example.BrainHelp_TFG.Controller;


import com.example.BrainHelp_TFG.Entity.Cita;
import com.example.BrainHelp_TFG.Service.citaService;
import com.example.BrainHelp_TFG.utils.GenericResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/citas")
public class citaController {
    private final citaService service;

    public citaController(citaService service) {
        this.service = service;
    }


    @GetMapping("/todas/{id}")
    public GenericResponse listarCitas(@PathVariable String id) {
        System.out.println("El id es " + id);
        int idParseado = Integer.parseInt(id);
        return this.service.listarCitas(idParseado);
    }




    @PostMapping("")
    public GenericResponse guardar(@RequestBody Cita cita){
        System.out.println(cita.getHora()+"Hora");
        return this.service.guardarCita(cita);
    }
    @PostMapping("/borrar/{id}")
    public GenericResponse borrar(@PathVariable Integer id){
        System.out.println("el id es:"+id);
        return this.service.borrarCita(id);
    }
}