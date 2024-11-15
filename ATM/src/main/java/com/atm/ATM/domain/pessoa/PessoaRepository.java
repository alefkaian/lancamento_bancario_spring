package com.atm.ATM.domain.pessoa;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    List<DadosListagemPessoa> findByAtivoTrue(Pageable pageable);
}
