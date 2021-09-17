package com.example.teoloblog.service.referencia;

import java.util.List;

import com.example.teoloblog.dto.referencia.ReferenciaDTO;
import com.example.teoloblog.dto.referencia.ReferenciaFormDTO;

public interface ReferenciaService {
    List<ReferenciaDTO> listarReferencias();
    ReferenciaDTO buscarReferenciaPorId(Integer codigoReferencia) throws Exception;

    ReferenciaDTO adicionaReferencia(ReferenciaFormDTO referenciaForm) throws Exception;
    ReferenciaDTO editarReferencia(Integer codigoReferencia, ReferenciaFormDTO referenciaForm) throws Exception;
 
    void excluirReferencia(Integer codigoReferencia) throws Exception;
}
