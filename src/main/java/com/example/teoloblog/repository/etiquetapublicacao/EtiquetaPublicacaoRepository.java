package com.example.teoloblog.repository.etiquetapublicacao;

import com.example.teoloblog.domain.etiquetapublicacao.EtiquetaPublicacao;
import com.example.teoloblog.domain.etiquetapublicacao.EtiquetaPublicacaoPK;
import com.example.teoloblog.domain.publicacao.Publicacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EtiquetaPublicacaoRepository extends JpaRepository<EtiquetaPublicacao, EtiquetaPublicacaoPK> {
//    public List<EtiquetaPublicacao> dele(Publicacao publicacao);
    void deleteById_Publicacao(Publicacao publicacao);
}
