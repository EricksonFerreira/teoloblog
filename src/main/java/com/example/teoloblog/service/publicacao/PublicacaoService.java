package com.example.teoloblog.service.publicacao;

import java.util.List;

import com.example.teoloblog.dto.publicacao.PublicacaoDTO;
import com.example.teoloblog.dto.publicacao.PublicacaoFormDTO;

public interface PublicacaoService {
    List<PublicacaoDTO> listarPublicacaos();
    PublicacaoDTO buscarPublicacaoPorId(Integer codigoPublicacao) throws Exception;

    PublicacaoDTO adicionaPublicacao(PublicacaoFormDTO publicacaoForm) throws Exception;
    PublicacaoDTO editarPublicacao(Integer codigoPublicacao, PublicacaoFormDTO publicacaoForm) throws Exception;
 
    void excluirPublicacao(Integer codigoPublicacao) throws Exception;
}
