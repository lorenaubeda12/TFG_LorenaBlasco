package com.example.BrainHelp_TFG.Service;

import com.example.BrainHelp_TFG.Entity.Usuario;
import com.example.BrainHelp_TFG.Repository.UsuarioRepository;
import com.example.BrainHelp_TFG.utils.GenericResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.example.BrainHelp_TFG.utils.Global.*;


@Service
@Transactional
public class usuarioService {
    private final UsuarioRepository repository;

    public usuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    //Método para iniciar sesión
    public GenericResponse<Usuario> login(String email, String contrasenia) {
        Optional<Usuario> optU = this.repository.login(email, contrasenia);
        if (optU.isPresent()) {
            return new GenericResponse<Usuario>(TIPO_AUTH, RPTA_OK, "Has iniciado sesión correctamente", optU.get());
        } else {
            return new GenericResponse<Usuario>(TIPO_AUTH, RPTA_WARNING, "Lo sentimos, ese usuario no existe", new Usuario());
        }
    }

    //Método para guardar credenciales del usuario
    public GenericResponse guardarUsuario(Usuario u) {
        Optional<Usuario> optU = this.repository.findById(u.getId_Usuario());
        int idf = optU.isPresent() ? optU.get().getId_Usuario() : 0;
        if (idf == 0) {
            return new GenericResponse(TIPO_RESULT, RPTA_WARNING, "No corresponde con ninguno de nuestros usuarios", null);
        } else {
            return new GenericResponse(TIPO_DATA, RPTA_OK, "Datos del usuario actualizados", this.repository.save(u));
        }
    }


    //Metodo para crear usuario y actualizar datos
    public GenericResponse save(Usuario user) {
        Optional<Usuario> opt = this.repository.findById(user.getId_Usuario());
        int id = opt.isPresent() ? opt.get().getId_Usuario() : 0;

        if (repository.existByEmail(user.getEmail().trim())) {
            return new GenericResponse(TIPO_RESULT, RPTA_WARNING, "Lo sentimos, este usuario ya existe con este email", null);
        } else {
            //Guardar
            user.setId_Usuario(id);
            return new GenericResponse(TIPO_DATA, RPTA_OK, "Usuario registrado correctamente", this.repository.save(user));
        }
    }


    public GenericResponse listarDatos(int id){
        return  new GenericResponse(TIPO_DATA,RPTA_OK,OPERACION_CORRECTA,this.repository.listarDatos(id));

    }



}
