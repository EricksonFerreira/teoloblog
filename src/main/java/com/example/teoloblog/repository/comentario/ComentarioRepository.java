package com.example.teoloblog.repository.comentario;

import com.example.teoloblog.domain.comentario.Comentario;
import com.example.teoloblog.domain.publicacao.Publicacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {
    void deleteByPublicacao(Publicacao publicacao);
//    void deleteByPublicacao_Codigo(Integer publicacao_id);

}
