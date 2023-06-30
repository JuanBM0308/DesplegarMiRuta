package com.miruta.api.servicios;

import com.miruta.api.modelos.UsuarioModeloLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.miruta.api.entidades.Usuario;
import com.miruta.api.interfaces.InUsuarioDao;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicioImpl implements InUsuarioServicio{

    //Objeto DAO(Repositorio) de usuario
    @Autowired
    InUsuarioDao usuarioDao;

    //Objeto mail para manejo de correos electronicos
    @Autowired
    JavaMailSender mailSender;



    //Metodo listar todos los usuarios
    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioDao.findAll();
    }



    //Metodo login usuario
    @Override
    public String loginUsuario(UsuarioModeloLogin usuarioModeloLogin) {
        String respuesta = "{\n" +
                "\"acceso\": false\n" +
                "}";

        Usuario usuario = usuarioDao.findByCorreoUsu(usuarioModeloLogin.getCorreoUsu()).orElse(null);

        if (usuario != null) {
            if (usuario.getContraseniaUsu().equals(usuarioModeloLogin.getContraseniaUsu())) {
                respuesta = "{\n" +
                        "\"acceso\": true,\n" +
                        "\"idUsu\": "+ usuario.getIdentificacionUsu() + "\n" +
                        "}";
            }
        }

        return respuesta;
    }



    //Metodo buscar usuario por id
    @Override
    public Optional<Usuario> getUsuario(Long identificacionUsu) {
        return usuarioDao.findById(identificacionUsu);
    }



    //Metodo comprobar usuario nuevo
    @Override
    public String comprobarUsuario(Usuario usuario) {
        String respuesta;

        if (!usuarioDao.existsById(usuario.getIdentificacionUsu())) {
            Usuario usuarioCorreo = usuarioDao.findByCorreoUsu(usuario.getCorreoUsu()).orElse(null);

            if (usuarioCorreo == null) {
                respuesta = "{\n" +
                        "\"permiso\": true,\n" +
                        "";

                int[] pines = new int[5];

                for (int i = 0; i < 5; i++) {
                    int pin = (int)(Math.random() * 10);

                    if (i == 4) {
                        respuesta += "\"pin"+(i+1)+"\": "+pin+"\n";

                    } else {
                        respuesta += "\"pin"+(i+1)+"\": "+pin+",\n";
                    }

                    pines[i] = pin;
                }

                respuesta += "}";

                enviarEmail(pines, usuario);

            } else {
                respuesta = "{\n" +
                        "\"permiso\": false,\n" +
                        "\"mensaje\": 'Usuario con correo "+usuario.getCorreoUsu()+" ya existente'\n" +
                        "}";
            }

        } else {
            respuesta = "{\n" +
                    "\"permiso\": false,\n" +
                    "\"mensaje\": 'Usuario con identificion "+usuario.getIdentificacionUsu()+" ya existente'\n" +
                    "}";
        }

        return respuesta;
    }



    //Metodo eliminar usuario
    @Override
    public String eliminarUsuario(Long identificacionUsu) {
        String respuesta = "{'respuesta' : 'Error eliminar usuario'}";

        if (usuarioDao.existsById(identificacionUsu)){
            usuarioDao.deleteById(identificacionUsu);
            respuesta = "{'respuesta' : 'Usuario eliminado con exito'}";
        }

        return respuesta;
    }



    //Metodo guardar usuario nuevo
    @Override
    public String guardarUsuario(Usuario usuario) {
        usuarioDao.save(usuario);
        return "{\n" +
                "\"registro\": true\n" +
                "}";
    }







    //Metodo para enviar el email con los pines de comprobacion
    private void enviarEmail(int[] pines, Usuario usuario) {
        SimpleMailMessage emailMessage = new SimpleMailMessage();
        String message = "Pin de comprobacion\n";

        emailMessage.setFrom("miruta983@gmail.com");
        emailMessage.setTo(usuario.getCorreoUsu());
        emailMessage.setSubject("Comprobacion de correo electronico Mi Ruta");

        for(int pin: pines) {
            message += pin;
        }

        emailMessage.setText(message);

        mailSender.send(emailMessage);
    }
}
