package com.example.teoloblog.service.etiqueta;

import java.util.List;

import com.example.teoloblog.dto.etiqueta.EtiquetaDTO;
import com.example.teoloblog.dto.etiqueta.EtiquetaFormDTO;



public interface EtiquetaService {

    List<EtiquetaDTO> listarEtiquetas();
    EtiquetaDTO buscarEtiquetaPorId(Integer codigoEtiqueta) throws Exception;

    EtiquetaDTO adicionarEtiqueta(EtiquetaFormDTO etiquetaForm);
    EtiquetaDTO editarEtiqueta(Integer codigoEtiqueta, EtiquetaFormDTO etiquetaForm) throws Exception;

    void excluirEtiqueta(Integer codigoEtiqueta) throws Exception;

    
}