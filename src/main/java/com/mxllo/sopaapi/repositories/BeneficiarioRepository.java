package com.mxllo.sopaapi.repositories;

import com.mxllo.sopaapi.models.Beneficiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface BeneficiarioRepository extends JpaRepository<Beneficiario, UUID> {
    Optional<Beneficiario> findByCpf(String cpf);
    boolean existsBeneficiarioByCpf(String cpf);
    boolean existsBeneficiarioByRg(String rg);

    void deleteByCpf(String cpf);

    Optional<Beneficiario> findByRg(String rg);

    void deleteByRg(String identificacao);
}
