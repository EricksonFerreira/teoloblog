package com.example.teoloblog.service.etiqueta;

import com.example.teoloblog.domain.etiqueta.Etiqueta;
import com.example.teoloblog.dto.etiqueta.EtiquetaDTO;
import com.example.teoloblog.dto.etiqueta.EtiquetaFormDTO;

import java.util.List;

public interface EtiquetaService {
    public List<EtiquetaDTO> listaEtiqueta();
    public EtiquetaDTO buscaEtiquetaPorCodigo(Integer codigo) throws Exception;

    public EtiquetaDTO adicionaEtiqueta(EtiquetaFormDTO etiquetaFormDTO);
    public EtiquetaDTO editaEtiqueta(Integer id,EtiquetaFormDTO etiquetaFormDTO) throws Exception;

    public void deletaEtiqueta(Integer id) throws Exception;
}
