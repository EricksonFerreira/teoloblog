package com.example.teoloblog.repository.usuario;

import com.example.teoloblog.domain.funcao.Funcao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.teoloblog.domain.usuario.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    public Optional<Usuario> findByFuncao(Funcao codigo);
}