package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
public class PhoneDTO {


    private Integer id;

    private String number;

    private String citycode;

    private String contrycode;

}
