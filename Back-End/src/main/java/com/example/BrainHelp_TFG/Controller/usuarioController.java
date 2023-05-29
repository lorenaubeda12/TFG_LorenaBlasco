package com.example.BrainHelp_TFG.Controller;


import com.example.BrainHelp_TFG.Entity.Usuario;
import com.example.BrainHelp_TFG.Service.usuarioService;
import com.example.BrainHelp_TFG.utils.GenericResponse;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/usuario")
public class usuarioController {
    private final usuarioService service;

    public usuarioController(usuarioService service) {
        this.service = service;
    }

    /*Hacer el login*/
    @PostMapping("/login")
    public GenericResponse<Usuario> login(HttpServletRequest request){
        String email = request.getParameter("email");
        String contrasenia = request.getParameter("pass");
        System.out.println(email + " + " + contrasenia);
        System.out.println(request.toString());
        return this.service.login(email, contrasenia);
    }

    @PostMapping(value = "", consumes = {"application/json"})
    public GenericResponse guardar(@RequestBody Usuario u){
        System.out.println(u.getApellidosUsuario()+","+u.getNombreUsuario()+","+u.getEmail());
        return this.service.save(u);
    }



    @PostMapping(value = "/actualizar", consumes = {"application/json"})
    public GenericResponse actualizar(@RequestBody Usuario u){
        System.out.println(u.getApellidosUsuario()+","+u.getNombreUsuario()+","+u.getEmail());
        return this.service.guardarUsuario(u);
    }


    @GetMapping("/consultar/{id}")
    public GenericResponse listarCitas(@PathVariable String id) {
        System.out.println("El id es " + id);
        int idParseado = Integer.parseInt(id);
        return this.service.listarDatos(idParseado);
    }

}
