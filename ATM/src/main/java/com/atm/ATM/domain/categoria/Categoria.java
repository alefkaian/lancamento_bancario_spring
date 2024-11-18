package com.atm.ATM.domain.categoria;

import com.atm.ATM.domain.pessoa.DadosAtualizacaoPessoa;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
@Entity(name = "Categoria")
@Table(name = "categorias")
public class Categoria {
    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Boolean ativo;

    public Categoria(DadosCadastroCategoria dados){
        this.nome = dados.nome();
        this.ativo = true;
    }

    public void atualizarInformacoes(@Valid DadosAtualizacaoCategoria dados) {
        if (dados.nome() != null) this.nome = dados.nome();
        if (dados.ativo() != null) this.ativo = dados.ativo();
    }

    public void excluir() {
        this.ativo = false;
    }
}
