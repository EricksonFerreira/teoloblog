package com.example.teoloblog.repository.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.teoloblog.domain.usuario.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
        
}