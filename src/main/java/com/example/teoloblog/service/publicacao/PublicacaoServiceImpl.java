package com.example.teoloblog.service.publicacao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.teoloblog.convert.publicacao.PublicacaoConvert;
import com.example.teoloblog.domain.publicacao.Publicacao;
import com.example.teoloblog.domain.autor.Autor;
import com.example.teoloblog.domain.etiqueta.Etiqueta;
import com.example.teoloblog.dto.publicacao.PublicacaoDTO;
import com.example.teoloblog.dto.publicacao.PublicacaoFormDTO;
import com.example.teoloblog.repository.publicacao.PublicacaoRepository;
import com.example.teoloblog.repository.autor.AutorRepository;
import com.example.teoloblog.repository.etiqueta.EtiquetaRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PublicacaoServiceImpl implements PublicacaoService{

    private final PublicacaoRepository publicacaoRepository;
    private final EtiquetaRepository etiquetaRepository;
    private final AutorRepository autorRepository;

    @Override
    public List<PublicacaoDTO> listarPublicacaos() {
        List<Publicacao> publicacaoList = publicacaoRepository.findAll();
        return PublicacaoConvert.publicacaoDomainListToDTOlist(publicacaoList);
    }

    @Override
    public PublicacaoDTO buscarPublicacaoPorId(Integer codigoPublicacao) throws Exception {
        Optional<Publicacao> publicacaoOpt = publicacaoRepository.findById(codigoPublicacao);
    
        if (!publicacaoOpt.isPresent()){
            throw new Exception("Publicacao não encontrado");
        }

        return PublicacaoConvert.publicacaoDomainToDTO(publicacaoOpt.get());
    }

    @Override
    public PublicacaoDTO adicionaPublicacao(PublicacaoFormDTO publicacaoForm) throws Exception {

        List<Etiqueta> estiquetasId = etiquetaRepository.findByIdIn(publicacaoForm.getEtiquetaId());
        
        // Optional<Etiqueta> etiquetaOpt = etiquetaRepository.findById(estiquetasId);
        
        if (estiquetasId.size() != publicacaoForm.getEtiquetaId().size()){
            throw new Exception("Etiqueta não encontrada");
        }

        Optional<Autor> authorOpt = autorRepository.findById(publicacaoForm.getAutorId());
        
        if (!authorOpt.isPresent()){
            throw new Exception("Autor não encontrado");
        }

        Publicacao entity = PublicacaoConvert.publicacaoFormToEtiquetaEntity(publicacaoForm);
        // entity.setEtiqueta(etiquetaOpt.get());
        entity.setAutor(authorOpt.get());
        publicacaoRepository.save(entity);

        return PublicacaoConvert.publicacaoDomainToDTO(entity);
    }

    @Override
    public PublicacaoDTO editarPublicacao(Integer codigoPublicacao, PublicacaoFormDTO publicacaoForm) throws Exception {
        // Optional<Publicacao> publicacaoOpt = publicacaoRepository.findById(codigoPublicacao);

        // if (!publicacaoOpt.isPresent()){
        //     throw new Exception("Publicacao não encontrado");
        // }

        // Optional<Etiqueta> etiquetaOpt = etiquetaRepository.findById(publicacaoForm.getEtiquetaId());
        
        // if (!etiquetaOpt.isPresent()){
        //     throw new Exception("Etiqueta não encontrada");
        // }

        // Optional<Autor> authorOpt = autorRepository.findById(publicacaoForm.getEtiquetaId());
        
        // if (!authorOpt.isPresent()){
        //     throw new Exception("Autor não encontrado");
        // }

        // Publicacao entity = publicacaoOpt.get();
        // entity.setTitulo(publicacaoForm.getTitulo());
        // entity.setTexto(publicacaoForm.getTexto());
        // entity.setData(publicacaoForm.getData());
        // // entity.setEtiqueta(etiquetaOpt.get());
        // entity.setAutor(authorOpt.get());
        // publicacaoRepository.save(entity);

        // return PublicacaoConvert.publicacaoDomainToDTO(publicacaoOpt.get()); 
            return  null;
    }

    @Override
    public void excluirPublicacao(Integer codigoPublicacao) throws Exception {
        Optional<Publicacao> publicacaoOpt = publicacaoRepository.findById(codigoPublicacao);

        if(!publicacaoOpt.isPresent()){
            throw new Exception("Publicacao não encontrado");
        }

        publicacaoRepository.delete(publicacaoOpt.get());
    }
}
