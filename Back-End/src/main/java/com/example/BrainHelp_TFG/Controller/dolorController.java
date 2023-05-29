package com.example.BrainHelp_TFG.Controller;


import com.example.BrainHelp_TFG.Service.dolorService;
import com.example.BrainHelp_TFG.utils.GenericResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/tiposDolor")
public class dolorController {
    private final dolorService service;

    public dolorController(dolorService service) {
        this.service = service;
    }


    @GetMapping("/todos")
    public GenericResponse listarTiposDolor() {
        return this.service.listarDolores();
    }


    @GetMapping("/miDolor/{id}")
    public GenericResponse miDolor(@PathVariable int id) {
        return this.service.miDolor(id);
    }
}