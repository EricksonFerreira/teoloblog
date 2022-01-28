package com.example.teoloblog.service.login;

import com.example.teoloblog.domain.usuario.Usuario;
import com.example.teoloblog.dto.login.LoginDTOForm;
import com.example.teoloblog.dto.login.SessaoDTO;
import com.example.teoloblog.dto.usuario.UsuarioDTO;
import com.example.teoloblog.repository.usuario.UsuarioRepository;
import com.example.teoloblog.security.JWTCreator;
import com.example.teoloblog.security.JWTObject;
import com.example.teoloblog.security.SecurityConfig;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Date;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginService{

    private final PasswordEncoder encoder;
    private final UsuarioRepository repository;

    public SessaoDTO logar(@RequestBody LoginDTOForm login){
        Optional<Usuario> usuarioOpt = repository.findByUsername(login.getUsername());
        if(!usuarioOpt.isPresent()){
            throw new RuntimeException("Erro ao tentar fazer login");
        }
        boolean passwordOk =  usuarioOpt.get().getPassword().equals(login.getPassword());
        if (!passwordOk) {
            throw new RuntimeException("Senha inválida para o login: " + login.getUsername());
        }
        //Estamos enviando um objeto Sessão para retornar mais informações do usuário
        SessaoDTO sessao = new SessaoDTO();
        sessao.setLogin(usuarioOpt.get().getUsername());
        JWTObject jwtObject = new JWTObject();
        jwtObject.setIssuedAt(new Date(System.currentTimeMillis()));
        jwtObject.setExpiration((new Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION)));
        jwtObject.setFuncao(usuarioOpt.get().getFuncao().getId());
        sessao.setToken(JWTCreator.create(SecurityConfig.KEY, jwtObject));
        sessao.setPrefix(SecurityConfig.PREFIX);
        return sessao;
    }
}
