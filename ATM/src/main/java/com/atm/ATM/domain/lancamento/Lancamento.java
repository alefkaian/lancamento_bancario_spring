package com.atm.ATM.domain.lancamento;

import com.atm.ATM.domain.categoria.Categoria;
import com.atm.ATM.domain.categoria.CategoriaRepository;
import com.atm.ATM.domain.pessoa.Pessoa;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.concurrent.CancellationException;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
@Entity(name = "Lancamento")
@Table(name = "lancamentos")
public class Lancamento {
    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    @Column(name = "data_vencimento")
    private LocalDate dataVencimento;
    @Column(name = "data_pagamento")
    private LocalDate dataPagamento;
    private BigDecimal valor;
    private String observacao;
    @Enumerated(EnumType.STRING)
    private TipoLancamento tipo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_categoria")
    private Categoria categoria;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_pessoa")
    private Pessoa pessoa;
    private Boolean ativo;

    public Lancamento(DadosCadastroLancamento dados, Categoria categoria, Pessoa pessoa){
        this.descricao = dados.descricao();
        this.dataVencimento = dados.dataVencimento();
        this.dataPagamento = dados.dataPagamento();
        this.valor = dados.valor();
        this.observacao = dados.observacao();
        this.tipo = dados.tipo();
        this.categoria = categoria;
        this.pessoa = pessoa;
        this.ativo = true;
    }

    public void atualizarInformacoes(@Valid DadosAtualizacaoLancamento dados, Categoria categoria) {
        if (dados.descricao() != null) this.descricao = dados.descricao();
        if (dados.valor() != null) this.valor = dados.valor();
        if (dados.observacao() != null) this.observacao = dados.observacao();
        if (dados.tipo() != null) this.tipo = dados.tipo();
        if (dados.ativo() != null) this.ativo = dados.ativo();
        if (categoria != null) this.categoria = categoria;
    }

    public void excluir() {
        this.ativo = false;
    }
}
