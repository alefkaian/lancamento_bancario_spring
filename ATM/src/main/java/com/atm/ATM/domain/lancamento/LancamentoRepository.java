package com.atm.ATM.domain.lancamento;

import com.atm.ATM.domain.pessoa.DadosListagemPessoa;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
    List<DadosListagemLancamento> findByAtivoTrue(Pageable pageable);
}
