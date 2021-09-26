package com.example.teoloblog.service.referencia;

import com.example.teoloblog.dto.referencia.ReferenciaDTO;
import com.example.teoloblog.dto.referencia.ReferenciaFormDTO;

import java.util.List;

public interface ReferenciaService {
    public List<ReferenciaDTO> listaReferencias();
    public ReferenciaDTO buscaReferencia(Integer codigo) throws Exception;
    public ReferenciaDTO adicionaReferencia(ReferenciaFormDTO referenciaFormDTO) throws Exception;
    public ReferenciaDTO editaReferencia(Integer codigo,ReferenciaFormDTO referenciaFormDTO) throws Exception;
    public void deletaReferencia(Integer codigo) throws Exception;
}
