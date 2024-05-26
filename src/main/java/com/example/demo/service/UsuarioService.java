package com.example.demo.service;

import com.example.demo.dto.PhoneDTO;
import com.example.demo.dto.RespuestaGenerica;
import com.example.demo.dto.UsuarioDTO;
import com.example.demo.model.Contact;
import com.example.demo.model.Phone;
import com.example.demo.model.Usuario;
import com.example.demo.repository.ContactRepository;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }
    private static final SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public Optional<Usuario> findById(int id) {
        return usuarioRepository.findById(id);
    }

    public RespuestaGenerica saveContact(UsuarioDTO contact) {
        RespuestaGenerica respuesta = new RespuestaGenerica();
        Usuario usuario = new Usuario();
        Optional<Usuario> usuarioValid = usuarioRepository.findByEmail(contact.getEmail());
        if(usuarioValid.isPresent()){
            respuesta.setData(null);
            respuesta.setMensaje("EL correo ya esta registrado");
            return respuesta;
        }
        try {
            usuario.setName(contact.getName());
            Boolean correoValido = contact.getEmail().matches("^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$");
            if(!correoValido){
                respuesta.setData(null);
                respuesta.setMensaje("EL correo no tiene formato valido");
                return respuesta;
            }
            usuario.setEmail(contact.getEmail());
            // expresion regular para  clave 5 letras mayusculas o minisculas en 10
            Pattern pat = Pattern.compile("[a-zA-Z]{5,10}");
            Matcher mat = pat.matcher(contact.getPassword());
            Boolean claveValida = false;
            if (mat.matches()) {
                System.out.println("SI");
                claveValida = true;
            } else {
                System.out.println("NO");
                claveValida = false;
            }
            if(!claveValida){
                respuesta.setData(null);
                respuesta.setMensaje("La clave es invalida");
                return respuesta;
            }
            usuario.setPassword(contact.getPassword());
            List<Phone> phones = new ArrayList<>();
            for (PhoneDTO phoneDTO : contact.getPhones()){
                Phone phone = new Phone();
                phone.setCitycode(phoneDTO.getCitycode());
                phone.setContrycode(phoneDTO.getContrycode());
                phone.setNumber(phoneDTO.getNumber());
                phones.add(phone);
            }
            usuario.setPhones(phones);
            respuesta.setData(usuarioRepository.save(usuario));
            respuesta.setMensaje("registro grabado");

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            respuesta.setCreated(sdf3.format(timestamp));
            respuesta.setModified(sdf3.format(timestamp));
            respuesta.setIsactive(true);
        }catch (Exception e){
            respuesta.setMensaje(e.getMessage());
            respuesta.setData(null);
        }


        return respuesta;

    }

   /* public Contact updateContact(int id, Contact contact) {
        Usuario updatedContact = usuarioRepository.findById(id).orElse(null);
        updatedContact.setName(contact.getName());
        updatedContact.setEmail(contact.getEmail());
        updatedContact.setCountry(contact.getCountry());
        return usuarioRepository.save(updatedContact);
    }*/

    public void deleteById(int id) {
        usuarioRepository.deleteById(id);
    }

}
