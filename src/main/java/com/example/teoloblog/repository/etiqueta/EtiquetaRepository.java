package com.example.teoloblog.repository.etiqueta;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.example.teoloblog.domain.etiqueta.Etiqueta;

public interface EtiquetaRepository extends JpaRepository<Etiqueta, Integer> {
      public List<Etiqueta> findByIdIn(List<Integer> etiquetas);
}