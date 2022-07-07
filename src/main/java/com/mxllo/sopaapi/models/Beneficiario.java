package com.mxllo.sopaapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Data
@NoArgsConstructor
@Entity
public class Beneficiario extends Pessoa{
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "beneficiario")
    @Nullable
    private Collection<DoacaoRecebida> doacoesRecebidas;

    public Beneficiario(String nome, String cpf, String rg, LocalDate dataDeNascimento, Contato contato) {
        super(nome, cpf, rg, dataDeNascimento, contato);
        this.doacoesRecebidas = new ArrayList<>();
    }
}
