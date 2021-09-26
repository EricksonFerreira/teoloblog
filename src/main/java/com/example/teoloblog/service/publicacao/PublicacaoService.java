package com.example.teoloblog.service.publicacao;

import com.example.teoloblog.dto.publicacao.PublicacaoDTO;
import com.example.teoloblog.dto.publicacao.PublicacaoFormDTO;

import java.util.List;

public interface PublicacaoService {
    public List<PublicacaoDTO> listaPublicacoes();
    public PublicacaoDTO buscaPublicacao(Integer codigo) throws Exception;
    public PublicacaoDTO adicionaPublicacao(PublicacaoFormDTO publicacaoFormDTO) throws Exception;
    public PublicacaoDTO editaPublicacao(Integer codigo,PublicacaoFormDTO publicacaoFormDTO) throws Exception;
    public void deletaPublicacao(Integer codigo) throws Exception;
}
