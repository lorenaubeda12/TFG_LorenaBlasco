package com.example.BrainHelp_TFG.Controller;


import com.example.BrainHelp_TFG.Entity.Registro;
import com.example.BrainHelp_TFG.Service.registroService;
import com.example.BrainHelp_TFG.utils.GenericResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/regis")
public class registroController {
    private final registroService service;

    public registroController(registroService service) {
        this.service = service;
    }

    @GetMapping("/misRegistros/{id}")
    public GenericResponse listarRegistros(@PathVariable String id) {
        System.out.println("El id es " + id);
        int idParseado = Integer.parseInt(id);
        return this.service.listarRegistros(idParseado);
    }

    @PostMapping(value = "/", consumes = {"application/json"})
    public GenericResponse guardar(@RequestBody Registro r) {
        System.out.println("Datos del registro: Fecha ");
        System.out.println(r.getFechaRegistro());
        System.out.println("Datos del registro: Duracion");
        System.out.println(r.getDuracionCrisis());
        System.out.println("Datos del registro: Intesindad");
        System.out.println(r.getIntensidad());
        System.out.println("Datos del registro: medicacion ");
        System.out.println(r.getId_Medicacion());
        System.out.println("Datos del registro: dolor");
        System.out.println(r.getId_Dolor());
        System.out.println("Datos del registro: desencadenante");
        System.out.println(r.getId_Desencadenante());
        System.out.println("Datos del registro: usuario");
        System.out.println(r.getId_Usuario());

        System.out.println(r);
        return this.service.save(r);
    }
    @PostMapping("/borrar/{id}")
    public GenericResponse borrar(@PathVariable Integer id){
        System.out.println("el id es:"+id);
        return this.service.borrarRegistro(id);
    }



}