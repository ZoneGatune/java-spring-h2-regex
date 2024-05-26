package com.example.demo.dto;

import com.example.demo.model.Phone;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
public class UsuarioDTO {

    private Integer id;

    private String name;

    private String email;

    private String password;

    private List<PhoneDTO> phones;

}
