package com.example.BrainHelp_TFG.Controller;


import com.example.BrainHelp_TFG.Entity.Medicacion;
import com.example.BrainHelp_TFG.Service.medicacionService;
import com.example.BrainHelp_TFG.utils.GenericResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/medicacion")
public class medicacionController {
    private final medicacionService service;

    public medicacionController(medicacionService service) {
        this.service = service;
    }


    @GetMapping("/todos")
    public GenericResponse listarMedicacion() {
        return this.service.listarMedicamentos();
    }



    @GetMapping("/medicacionElegida/{id}")
    public GenericResponse miMedicacion(@PathVariable int id) {
        return this.service.miMedicacion(id);
    }

    @PostMapping("")
    public GenericResponse guardar(@RequestBody Medicacion m){
        return this.service.guardarMedicamento(m);
    }
}
