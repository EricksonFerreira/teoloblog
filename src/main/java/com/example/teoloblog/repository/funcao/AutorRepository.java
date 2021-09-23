package com.example.teoloblog.repository.funcao;

import com.example.teoloblog.domain.autor.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Integer> {
}
