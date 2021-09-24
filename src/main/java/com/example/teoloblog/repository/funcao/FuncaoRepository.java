package com.example.teoloblog.repository.funcao;

import com.example.teoloblog.domain.autor.Autor;
import com.example.teoloblog.domain.funcao.Funcao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncaoRepository extends JpaRepository<Funcao, Integer> {
}
