package com.mxllo.sopaapi.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum DiaDaSemana {
    SEGUNDA ("seg", 1),
    TERCA ("ter", 2),
    QUARTA ("qua", 3),
    QUINTA ("qui", 4),
    SEXTA ("sex", 5),
    SABADO ("sab", 6),
    DOMINGO ("dom", 7);

    private String abreviacao;
    private int id;

}
