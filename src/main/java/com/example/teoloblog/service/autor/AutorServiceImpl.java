package com.example.teoloblog.service.autor;

import com.example.teoloblog.convert.autor.AutorConvert;
import com.example.teoloblog.domain.autor.Autor;
import com.example.teoloblog.dto.autor.AutorDTO;
import com.example.teoloblog.dto.autor.AutorFormDTO;
import com.example.teoloblog.repository.autor.AutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AutorServiceImpl implements AutorService {

    private final AutorRepository autorRepository;

    @Override
    public List<AutorDTO> listaAutores(){
        List<Autor> autorList = autorRepository.findAll();
        return AutorConvert.autorDomainListToDTOlist(autorList);
    };
    @Override
    public AutorDTO buscarAutorPorId(Integer codigoAutor) throws Exception{
        Optional<Autor> autorOpt = autorRepository.findById(codigoAutor);

        if(!autorOpt.isPresent()){
            throw new Exception("Autor não está registrado!");
        }
        return AutorConvert.autorDomainToDTO(autorOpt.get());
    };

    @Override
    public AutorDTO adicionaAutor(AutorFormDTO autorForm){
        Autor entity = AutorConvert.autorFormToAutorEntity(autorForm);
        autorRepository.save(entity);
        return AutorConvert.autorDomainToDTO(entity);
    };
    @Override
    public AutorDTO editarAutor(Integer codigoAutor,AutorFormDTO autorForm) throws Exception{
        Optional<Autor> autorOpt = autorRepository.findById(codigoAutor);

        if(!autorOpt.isPresent()){
            throw new Exception("Autor não encontrado!");
        }
        Autor entity = autorOpt.get();
        entity.setNome(autorForm.getNome());
        entity.setImagem(autorForm.getImagem());
        entity.setDescricao(autorForm.getDescricao());
        autorRepository.save(entity);

        return AutorConvert.autorDomainToDTO(entity);
    };
    @Override
    public void excluirAutor(Integer codigoAutor) throws Exception{
        Optional<Autor> autorOpt = autorRepository.findById(codigoAutor);

        if(!autorOpt.isPresent()){
            throw new Exception("Autor não encontrado!");
        }

        autorRepository.delete(autorOpt.get());
    };
}
