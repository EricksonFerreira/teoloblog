package com.example.teoloblog.repository.referencia;

import com.example.teoloblog.domain.publicacao.Publicacao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.teoloblog.domain.referencia.Referencia;

public interface ReferenciaRepository extends JpaRepository<Referencia, Integer> {
    void deleteByPublicacao(Publicacao publicacao);

}