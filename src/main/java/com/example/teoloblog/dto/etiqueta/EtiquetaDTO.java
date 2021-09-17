package com.example.teoloblog.dto.etiqueta;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EtiquetaDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer codigo;
    private String nome;
}