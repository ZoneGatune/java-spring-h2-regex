package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
public class RespuestaGenerica {

    private String mensaje;
    private Object data;
    private String created;
    private String modified;
    private String last_login;
    private String token;
    private Boolean isactive;
}
