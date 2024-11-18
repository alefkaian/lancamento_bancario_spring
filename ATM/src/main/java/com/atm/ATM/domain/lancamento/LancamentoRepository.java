package com.atm.ATM.domain.lancamento;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
    Page<Lancamento> findAllByAtivoTrue(Pageable pageable);
}
