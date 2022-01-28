package com.example.teoloblog.service.login;

import com.example.teoloblog.dto.login.LoginDTOForm;
import com.example.teoloblog.dto.login.SessaoDTO;

public interface LoginService {
        public SessaoDTO logar(LoginDTOForm login);
}
