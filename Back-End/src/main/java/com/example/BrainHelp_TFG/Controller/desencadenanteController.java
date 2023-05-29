package com.example.BrainHelp_TFG.Controller;


import com.example.BrainHelp_TFG.Service.desencadenanteService;
import com.example.BrainHelp_TFG.utils.GenericResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/tiposDesencadenantes")
public class desencadenanteController {
    private final desencadenanteService service;

    public desencadenanteController(desencadenanteService service) {
        this.service = service;
    }


    @GetMapping("/todos")
    public GenericResponse listarDesencadenante() {
        return this.service.listarDesencadenantes();
    }


    @GetMapping("/miDesencadenante/{id}")
    public GenericResponse miDolor(@PathVariable int id) {
        return this.service.miDesencadenante(id);
    }

}
