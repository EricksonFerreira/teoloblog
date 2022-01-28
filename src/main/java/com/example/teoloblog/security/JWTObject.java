package com.example.teoloblog.security;

import java.util.Date;
import java.util.List;

public class JWTObject {
    private String subject; //Nome de criação
    private Date issuedAt; // Data de criação do token
    private Date expiration; // Data de expiração do token
    private Integer funcao; // Perfis de acesso

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(Date issuedAt) {
        this.issuedAt = issuedAt;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    public Integer getFuncao() {
        return funcao;
    }

//    public void setFuncao(List<Integer> funcao) {
      public void setFuncao(Integer funcao) {
        this.funcao = funcao;
    }
}
