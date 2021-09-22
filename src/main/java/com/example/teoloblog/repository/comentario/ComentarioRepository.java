package com.example.teoloblog.repository.comentario;

import com.example.teoloblog.domain.comentario.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {
}
