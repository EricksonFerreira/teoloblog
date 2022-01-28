package com.example.teoloblog.resource.login;

import com.example.teoloblog.dto.login.LoginDTOForm;
import com.example.teoloblog.dto.login.SessaoDTO;
import com.example.teoloblog.service.login.LoginServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/login")
@RequiredArgsConstructor
public class LoginResource {

    private final LoginServiceImpl loginServiceImpl;

    @PostMapping
        public ResponseEntity<SessaoDTO> login(@RequestBody LoginDTOForm loginDTOForm){
        SessaoDTO sessao = loginServiceImpl.logar(loginDTOForm);
        return ResponseEntity.ok(sessao);
    }
}
