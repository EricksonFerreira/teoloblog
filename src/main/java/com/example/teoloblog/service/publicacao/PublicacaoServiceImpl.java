package com.example.teoloblog.service.publicacao;

import com.example.teoloblog.convert.publicacao.PublicacaoConvert;
import com.example.teoloblog.domain.autor.Autor;
import com.example.teoloblog.domain.comentario.Comentario;
import com.example.teoloblog.domain.etiqueta.Etiqueta;
import com.example.teoloblog.domain.etiquetapublicacao.EtiquetaPublicacao;
import com.example.teoloblog.domain.etiquetapublicacao.EtiquetaPublicacaoPK;
import com.example.teoloblog.domain.publicacao.Publicacao;
import com.example.teoloblog.domain.usuario.Usuario;
import com.example.teoloblog.dto.publicacao.PublicacaoDTO;
import com.example.teoloblog.dto.publicacao.PublicacaoFormDTO;
import com.example.teoloblog.repository.autor.AutorRepository;
import com.example.teoloblog.repository.comentario.ComentarioRepository;
import com.example.teoloblog.repository.etiqueta.EtiquetaRepository;
import com.example.teoloblog.repository.etiquetapublicacao.EtiquetaPublicacaoRepository;
import com.example.teoloblog.repository.publicacao.PublicacaoRepository;
import com.example.teoloblog.repository.referencia.ReferenciaRepository;
import com.example.teoloblog.repository.usuario.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class PublicacaoServiceImpl implements PublicacaoService {

    private final PublicacaoRepository publicacaoRepository;
    private final AutorRepository autorRepository;
    private final EtiquetaRepository etiquetaRepository;
    private final EtiquetaPublicacaoRepository etiquetaPublicacaoRepository;
    private final ComentarioRepository comentarioRepository;
    private final ReferenciaRepository referenciaRepository;
    private final UsuarioRepository usuarioRepository;

    @Override
    public List<PublicacaoDTO> listaPublicacoes() {
        List<Publicacao> publicacoes = publicacaoRepository.findAll();
        return PublicacaoConvert.publicacaoDomainListToDTOlist(publicacoes);
    }

    @Override
    public PublicacaoDTO buscaPublicacao(Integer codigo) throws Exception {
        Optional<Publicacao> publicacaoOpt = publicacaoRepository.findById(codigo);
        if (!publicacaoOpt.isPresent()) {
            throw new Exception("Não existe essa publicação!");
        }

        return PublicacaoConvert.publicacaoDomainToDTO(publicacaoOpt.get());
    }

    @Override
    public PublicacaoDTO adicionaPublicacao(PublicacaoFormDTO publicacaoFormDTO) throws Exception {

        Optional<Usuario> usuarioOpt = usuarioRepository.findById(publicacaoFormDTO.getUsuarioId());
        if(!usuarioOpt.isPresent()){
            throw new Exception("Não existe esse usuario no sistema");
        }
        Optional<Autor> autorOpt = autorRepository.findById(publicacaoFormDTO.getAutorId());
        if(!autorOpt.isPresent()){
            throw new Exception("Não existe esse autor no sistema");
        }

        //Verifica se as etiquetas existem
        Stream<Integer> etiquetas = publicacaoFormDTO.getListaEtiquetaId().stream().filter(e -> {
            Optional<Etiqueta> etiquetaOpt = etiquetaRepository.findById(e.intValue());
            if(!etiquetaOpt.isPresent()) {
                return false;
            }
            return true;
        });
        if(etiquetas.count() != publicacaoFormDTO.getListaEtiquetaId().size()){
            throw new Exception("Existem etiquetas que não estão salvas no sistema!");
        }

        //Adicionei a etiqueta
        Publicacao publicacao =   Publicacao.builder()
                                            .titulo(publicacaoFormDTO.getTitulo())
                                            .texto(publicacaoFormDTO.getTexto())
                                            .data(publicacaoFormDTO.getData())
                                            .autor(autorOpt.get())
                                            .usuario(usuarioOpt.get())
                                            .build();
        Publicacao publicacaoSave = publicacaoRepository.save(publicacao);

        publicacaoFormDTO.getListaEtiquetaId().stream().forEach(e -> {
            Optional<Etiqueta> etiqueta = etiquetaRepository.findById(e);
            EtiquetaPublicacaoPK etiquetaPublicacaoPk = EtiquetaPublicacaoPK.builder()
                                                                            .etiqueta(etiqueta.get())
                                                                            .publicacao(publicacaoSave)
                                                                            .build();
            EtiquetaPublicacao etiquetaPublicacao = EtiquetaPublicacao.builder().id(etiquetaPublicacaoPk).build();
            etiquetaPublicacaoRepository.save(etiquetaPublicacao);
        });
        return PublicacaoConvert.publicacaoDomainToDTO(publicacao);
    }

    @Override
    @Transactional
    public PublicacaoDTO editaPublicacao(Integer codigo, PublicacaoFormDTO publicacaoFormDTO) throws Exception {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(publicacaoFormDTO.getUsuarioId());
        if(!usuarioOpt.isPresent()){
            throw new Exception("Não existe esse usuario no sistema");
        }
        Optional<Publicacao> publicacaoOpt = publicacaoRepository.findById(codigo);
        if(publicacaoOpt.isEmpty()){
            throw new Exception("Não existe essa publicacao no sistema");
        }

        Optional<Autor> autorOpt = autorRepository.findById(publicacaoFormDTO.getAutorId());
        if(!autorOpt.isPresent()){
            throw new Exception("Não existe esse autor no sistema");
        }

        Publicacao publicacao = publicacaoOpt.get();
        publicacao.setTitulo(publicacaoFormDTO.getTitulo());
        publicacao.setTexto(publicacaoFormDTO.getTexto());
        publicacao.setData(publicacaoFormDTO.getData());
        publicacao.setAutor(autorOpt.get());
        publicacao.setUsuario(usuarioOpt.get());
        Publicacao publicacaoSave = publicacaoRepository.save(publicacao);

        etiquetaPublicacaoRepository.deleteById_Publicacao(publicacaoSave);

        publicacaoFormDTO.getListaEtiquetaId().stream().forEach(e -> {
            Optional<Etiqueta> etiqueta = etiquetaRepository.findById(e);
            EtiquetaPublicacaoPK etiquetaPublicacaoPk = EtiquetaPublicacaoPK.builder()
                                                                        .etiqueta(etiqueta.get())
                                                                        .publicacao(publicacao)
                                                                        .build();
            EtiquetaPublicacao etiquetaPublicacao = EtiquetaPublicacao.builder().id(etiquetaPublicacaoPk).build();
            etiquetaPublicacaoRepository.save(etiquetaPublicacao);
        });
        return PublicacaoConvert.publicacaoDomainToDTO(publicacaoSave);
    }


    @Override
    @Transactional
    public void deletaPublicacao(Integer codigo) throws Exception {
        Optional<Publicacao> publicacaoOpt = publicacaoRepository.findById(codigo);
        if(publicacaoOpt.isEmpty()){
            throw new Exception("Não existe essa publicacao no sistema");
        }

        etiquetaPublicacaoRepository.deleteById_Publicacao(publicacaoOpt.get());
        comentarioRepository.deleteByPublicacao(publicacaoOpt.get());
        referenciaRepository.deleteByPublicacao(publicacaoOpt.get());
        publicacaoRepository.delete(publicacaoOpt.get());
    }
}
