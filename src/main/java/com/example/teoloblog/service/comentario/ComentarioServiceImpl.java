package com.example.teoloblog.service.comentario;

import com.example.teoloblog.convert.comentario.ComentarioConvert;
import com.example.teoloblog.domain.comentario.Comentario;
import com.example.teoloblog.domain.publicacao.Publicacao;
import com.example.teoloblog.domain.usuario.Usuario;
import com.example.teoloblog.dto.comentario.ComentarioDTO;
import com.example.teoloblog.dto.comentario.ComentarioFormDTO;
import com.example.teoloblog.repository.comentario.ComentarioRepository;
import com.example.teoloblog.repository.publicacao.PublicacaoRepository;
import com.example.teoloblog.repository.usuario.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ComentarioServiceImpl implements ComentarioService{

    ComentarioRepository comentarioRepository;
    PublicacaoRepository publicacaoRepository;
    UsuarioRepository usuarioRepository;

    @Override
    public List<ComentarioDTO> listarComentarios() {
        List<Comentario> comentarios = comentarioRepository.findAll();
        return ComentarioConvert.comentarioDomainListToDTOlist(comentarios);
    }

    @Override
    public ComentarioDTO buscarComentarioPorCodigo(Integer codigo) throws Exception {
          Optional<Comentario> publicacaoOpt = comentarioRepository.findById(codigo);
        if(!publicacaoOpt.isPresent()){
            throw new Exception("Não existe essa publicação!");
        }

        return ComentarioConvert.comentarioDomainToDTO(publicacaoOpt.get());
    }

    @Override
    public ComentarioDTO adicionaComentario(ComentarioFormDTO comentarioFormDTO) throws Exception {

        Optional<Usuario> usuarioOpt = usuarioRepository.findById(comentarioFormDTO.getUsuarioId());
        if(!usuarioOpt.isPresent()){
            throw new Exception("Não existe esse usuario no sistema");
        }

        Optional<Publicacao> publicacaoOpt = publicacaoRepository.findById(comentarioFormDTO.getPublicacaoId());
        if(!usuarioOpt.isPresent()){
            throw new Exception("Não existe essa publicação no sistema");
        }

        Comentario comentario =   Comentario.builder()
                                            .texto(comentarioFormDTO.getTexto())
                                            .data(comentarioFormDTO.getData())
                                            .usuario(usuarioOpt.get())
                                            .publicacao(publicacaoOpt.get())
                                            .build();
        comentarioRepository.save(comentario);

        return ComentarioConvert.comentarioDomainToDTO(comentario);
    }

    @Override
    public ComentarioDTO editaComentario(Integer codigo, ComentarioFormDTO comentarioFormDTO) throws Exception {

        Optional<Usuario> usuarioOpt = usuarioRepository.findById(comentarioFormDTO.getUsuarioId());
        if(!usuarioOpt.isPresent()){
            throw new Exception("Não existe esse usuario no sistema");
        }

        Optional<Publicacao> publicacaoOpt = publicacaoRepository.findById(comentarioFormDTO.getPublicacaoId());
        if(!usuarioOpt.isPresent()){
            throw new Exception("Não existe essa publicação no sistema");
        }

        Optional<Comentario> comentarioOpt = comentarioRepository.findById(codigo);
        if(!comentarioOpt.isPresent()){
            throw new Exception("Não existe essa comentario no sistema");
        }

        Comentario comentario = comentarioOpt.get();
        comentario.setTexto(comentarioFormDTO.getTexto());
        comentario.setData(comentarioFormDTO.getData());
        comentario.setUsuario(usuarioOpt.get());
        comentario.setPublicacao(publicacaoOpt.get());

        return ComentarioConvert.comentarioDomainToDTO(comentario);
    }

    @Override
    public void deletaComentario(Integer codigo) throws Exception {

        Optional<Comentario> comentarioOpt = comentarioRepository.findById(codigo);
        if(!comentarioOpt.isPresent()){
            throw new Exception("Não existe essa comentario no sistema");
        }
        comentarioRepository.deleteById(codigo);
    }
}
