package com.example.teoloblog.service.referencia;

import com.example.teoloblog.convert.publicacao.PublicacaoConvert;
import com.example.teoloblog.convert.referencia.ReferenciaConvert;
import com.example.teoloblog.domain.publicacao.Publicacao;
import com.example.teoloblog.domain.referencia.Referencia;
import com.example.teoloblog.dto.referencia.ReferenciaDTO;
import com.example.teoloblog.dto.referencia.ReferenciaFormDTO;
import com.example.teoloblog.repository.publicacao.PublicacaoRepository;
import com.example.teoloblog.repository.referencia.ReferenciaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Ref;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReferenciaServiceImpl implements ReferenciaService{

    public final ReferenciaRepository referenciaRepository;
    public final PublicacaoRepository publicacaoRepository;

    @Override
    public List<ReferenciaDTO> listaReferencias() {
         List<Referencia> referencias = referenciaRepository.findAll();
        return ReferenciaConvert.referenciaDomainListToDTOlist(referencias);
    }

    @Override
    public ReferenciaDTO buscaReferencia(Integer codigo) throws Exception {
        Optional<Referencia> usuarioOpt = referenciaRepository.findById(codigo);
        if(!usuarioOpt.isPresent()){
            throw new Exception("Não existe essa referência no sistema!");
        }

        return ReferenciaConvert.referenciaDomainToDTO(usuarioOpt.get());
    }

    @Override
    public ReferenciaDTO adicionaReferencia(ReferenciaFormDTO referenciaFormDTO) throws Exception {
        Optional<Publicacao> publicacaoOpt = publicacaoRepository.findById(referenciaFormDTO.getPublicacaoId());
        if(!publicacaoOpt.isPresent()){
            throw new Exception("Não existe essa referência no sistema!");
        }

        Referencia entity = Referencia.builder()
                                      .texto(referenciaFormDTO.getTexto())
                                      .publicacao(publicacaoOpt.get())
                                      .build();

        referenciaRepository.save(entity);

        return ReferenciaConvert.referenciaDomainToDTO(entity);
    }

    @Override
    public ReferenciaDTO editaReferencia(Integer codigo, ReferenciaFormDTO referenciaFormDTO) throws Exception {
        Optional<Referencia> referenciaOpt = referenciaRepository.findById(codigo);
        if(!referenciaOpt.isPresent()){
            throw new Exception("Não existe essa referência no sistema!");
        }

       Optional<Publicacao> publicacaoOpt = publicacaoRepository.findById(referenciaFormDTO.getPublicacaoId());
        if(!publicacaoOpt.isPresent()){
            throw new Exception("Não existe essa publicação no sistema!");
        }

        Referencia entity = referenciaOpt.get();
        entity.setTexto(referenciaFormDTO.getTexto());
        entity.setPublicacao(publicacaoOpt.get());
        referenciaRepository.save(entity);

        return ReferenciaConvert.referenciaDomainToDTO(entity);
    }

    @Override
    public void deletaReferencia(Integer codigo) throws Exception {
        Optional<Referencia> referenciaOpt = referenciaRepository.findById(codigo);
        if(!referenciaOpt.isPresent()){
            throw new Exception("Não existe essa referência no sistema!");
        }
        referenciaRepository.delete(referenciaOpt.get());
    }
}
