package com.mxllo.sopaapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mxllo.sopaapi.models.Contato;

import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContatoDTO {
    private String email;
    private String instagram;
    private String facebook;
    private Set<Long> telefones;

    public ContatoDTO(Contato contato) {
        this.email = contato.getEmail();
        this.instagram = contato.getInstagram();
        this.facebook = contato.getFacebook();
        this.telefones = contato.getTelefones();
    }
}
