package com.example.demo.controller;

import com.example.demo.dto.RespuestaGenerica;
import com.example.demo.dto.UsuarioDTO;
import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@RequestMapping(value = "/v1/usuario/")
@RestController
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(value = "guardar")
    public ResponseEntity<RespuestaGenerica> guardarReintento(@RequestBody UsuarioDTO usuarioDTO) {
        RespuestaGenerica respuesta = new RespuestaGenerica();
        respuesta = usuarioService.saveContact(usuarioDTO);

        return ResponseEntity.ok().body(respuesta);
    }
}
