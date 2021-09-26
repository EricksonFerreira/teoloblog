package com.example.teoloblog.service.publicacao;

import com.example.teoloblog.convert.publicacao.PublicacaoConvert;
import com.example.teoloblog.domain.autor.Autor;
import com.example.teoloblog.domain.etiqueta.Etiqueta;
import com.example.teoloblog.domain.etiquetapublicacao.EtiquetaPublicacao;
import com.example.teoloblog.domain.etiquetapublicacao.EtiquetaPublicacaoPK;
import com.example.teoloblog.domain.publicacao.Publicacao;
import com.example.teoloblog.dto.etiquetapublicacao.EtiquetaPublicacaoDTO;
import com.example.teoloblog.dto.publicacao.PublicacaoDTO;
import com.example.teoloblog.dto.publicacao.PublicacaoFormDTO;
import com.example.teoloblog.repository.autor.AutorRepository;
import com.example.teoloblog.repository.etiqueta.EtiquetaRepository;
import com.example.teoloblog.repository.publicacao.PublicacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class PublicacaoServiceImpl implements PublicacaoService{

    private final PublicacaoRepository publicacaoRepository;
    private final AutorRepository autorRepository;
    private final EtiquetaRepository etiquetaRepository;

    @Override
    public List<PublicacaoDTO> listaPublicacoes() {
        List<Publicacao> publicacoes = publicacaoRepository.findAll();
        return PublicacaoConvert.publicacaoDomainListToDTOlist(publicacoes);
    }

    @Override
    public PublicacaoDTO buscaPublicacao(Integer codigo) throws Exception {
        Optional<Publicacao> publicacaoOpt = publicacaoRepository.findById(codigo);
        if(!publicacaoOpt.isPresent()){
            throw new Exception("Não existe essa publicação!");
        }

        return PublicacaoConvert.publicacaoDomainToDTO(publicacaoOpt.get());
    }

    @Override
    public PublicacaoDTO adicionaPublicacao(PublicacaoFormDTO publicacaoFormDTO) throws Exception {

        Optional<Autor> autorOpt = autorRepository.findById(publicacaoFormDTO.getAutorId());
        if(autorOpt.isPresent()){
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
                                            .build();
        publicacaoRepository.save(publicacao);

        publicacaoFormDTO.getListaEtiquetaId().stream().forEach(e -> {
            Optional<Etiqueta> etiqueta = etiquetaRepository.findById(e);
//            EtiquetaPublicacao etiquetaPublicacao = null;
//                                                                              EtiquetaPublicacaoDTO.builder()
//                                                                            .etiqueta(etiqueta.get())
//                                                                            .publicacao(publicacao)
//                                                                            .build();
//            etiquetaPublicacaoPkRepository.save(etiquetaPublicacao);
//            etiquetaPublicacaoRepository.save(EtiquetaPublicacaoConvert.etiquetaPublicacaoDomainToDTO(etiquetaPublicacao));
        });
        return null;
    }

    @Override
    public PublicacaoDTO editaPublicacao(Integer codigo, PublicacaoFormDTO publicacaoFormDTO) throws Exception {
        return null;
    }

    @Override
    public void deletaPublicacao(Integer codigo) throws Exception {

    }
}
