package com.mxllo.sopaapi.controller;

import com.mxllo.sopaapi.dto.BeneficiarioCadastro;
import com.mxllo.sopaapi.dto.BeneficiarioDTO;
import com.mxllo.sopaapi.facade.BeneficiariosFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/beneficiario")
public class BeneficiarioController {
    @Autowired
    private BeneficiariosFacade facade;

    @GetMapping("/{identificacao}")
    public BeneficiarioDTO buscaBeneficiario(@PathVariable String identificacao){
        return facade.buscarBeneficiario(identificacao);
    }

    @PostMapping
    public BeneficiarioDTO cadastrarBeneficiario(@RequestBody BeneficiarioCadastro dto){
        return facade.cadastrarBeneficiario(dto);
    }

    @DeleteMapping("/{identificacao}")
    public void deletarBeneficiario(@PathVariable String identificacao){
        facade.deletarBeneficiario(identificacao);
    }

    @PutMapping("/{identificacao}")
    public BeneficiarioDTO atualizarBeneficiario(@PathVariable String identificacao, @RequestBody BeneficiarioCadastro dto){
        return facade.atualizarBeneficiario(identificacao, dto);
    }
}
