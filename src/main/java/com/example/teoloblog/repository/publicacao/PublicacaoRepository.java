package com.example.teoloblog.repository.publicacao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.teoloblog.domain.publicacao.Publicacao;

import java.util.List;

public interface PublicacaoRepository extends JpaRepository<Publicacao, Integer> {

}