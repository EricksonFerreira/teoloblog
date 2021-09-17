package com.example.teoloblog.repository.publicacao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.teoloblog.domain.publicacao.Publicacao;

public interface PublicacaoRepository extends JpaRepository<Publicacao, Integer> {

}