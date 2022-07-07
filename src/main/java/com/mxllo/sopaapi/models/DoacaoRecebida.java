package com.mxllo.sopaapi.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.lang.Nullable;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@Table(name = "doacoes_recebidas")
public class DoacaoRecebida {
    @Id
    @Column
    @Type(type = "uuid-char")
    private UUID idItem;
    private String nomeItem;
    private Long quantidade;
    @ManyToOne
    @JoinColumn(name = "doador_id")
    private Doador doador;
    @Nullable
    @ManyToOne
    @JoinColumn(name = "beneficiario_id")
    private Beneficiario beneficiario;

    public DoacaoRecebida(UUID idItem, String nomeItem, Long quantidade, Doador doador) {
        this.idItem = idItem;
        this.nomeItem = nomeItem;
        this.quantidade = quantidade;
        this.doador = doador;
    }


}
