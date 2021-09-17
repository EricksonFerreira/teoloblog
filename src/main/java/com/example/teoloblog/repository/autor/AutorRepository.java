package com.example.teoloblog.repository.autor;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.teoloblog.domain.autor.Autor;

public interface AutorRepository extends JpaRepository<Autor, Integer> {
        
}