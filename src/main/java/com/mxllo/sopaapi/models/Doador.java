package com.mxllo.sopaapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Doador extends Pessoa{
    private String cnpj;
    private LocalDate dataDeCadastro;
    @OneToMany(mappedBy = "doador")
    @Nullable
    private List<Doacao> doacoesFeitas;

    public Doador(String nome, String cpf, String rg, LocalDate dataDeNascimento, Contato contato, String cnpj, LocalDate dataDeCadastro) {
        super(nome, cpf, rg, dataDeNascimento, contato);
        this.cnpj = cnpj;
        this.dataDeCadastro = dataDeCadastro;
        this.doacoesFeitas = List.of();
    }
}
