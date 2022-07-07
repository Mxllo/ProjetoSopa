package com.mxllo.sopaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@AllArgsConstructor
@Data
public class DoacaoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nomeItem;
    private Long quantidade;
}
