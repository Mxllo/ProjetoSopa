package com.mxllo.sopaapi;

import com.mxllo.sopaapi.models.Beneficiario;
import com.mxllo.sopaapi.models.Contato;
import com.mxllo.sopaapi.models.Doacao;
import com.mxllo.sopaapi.models.Doador;
import com.mxllo.sopaapi.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SopaApiApplication implements CommandLineRunner {

    @Autowired
    BeneficiarioRepository beneficiarioRepository;
    @Autowired
    ContatoRepository contatoRepository;
    @Autowired
    DoacaoRepository doacaoRepository;
    @Autowired
    DoadorRepository doadorRepository;
    @Autowired
    VoluntarioRepository voluntarioRepository;
    @Autowired
    DoacaoRecebidaRepository doacaoRecebidaRepository;

    public static void main(String[] args) {
        SpringApplication.run(SopaApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Contato c1 = new Contato("lucasmellog@gmail.com", Set.of(1957709595L), null,null);
        Contato c2 = new Contato("lucasmellog@gmail.com", Set.of(1957709595L), null,null);
        System.out.println(c1.getId());
        contatoRepository.save(c1);
        contatoRepository.save(c2);
        Doador doador1 = new Doador("Lucas", "38399127841", "424642712", LocalDate.of(1997, 5, 23), c1, "00436860000172", LocalDate.now());
        doadorRepository.save(doador1);
        Doacao d1 = new Doacao("Caneta gel", 10L ,doador1);
        doacaoRepository.save(d1);
        Beneficiario b1 = new Beneficiario("Milena", "38355544421", "44555287X", LocalDate.of(1998, 7, 1), c2);
        System.out.println(b1.getId());
        beneficiarioRepository.save(b1);

        List<Doacao> doacoes = doacaoRepository.findAll();
        //doar
        Beneficiario benef = beneficiarioRepository.findByCpf("38355544421").orElseThrow(() -> new RuntimeException("Beneficiario não encontrado"));
        doacoes.get(0).getQuantidade();
        doacaoRepository.save(doacoes.get(0));
    }
}
