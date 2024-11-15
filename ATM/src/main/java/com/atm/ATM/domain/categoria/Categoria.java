package com.atm.ATM.domain.categoria;

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
    private boolean ativo;

    public Categoria(DadosCadastroCategoria dados){
        this.nome = dados.nome();
        this.ativo = true;
    }

    public void atualizarInformacoes(@Valid DadosCadastroCategoria dados) {
        if (dados.nome() != null) this.nome = dados.nome();
    }

    public void excluir() {
        this.ativo = false;
    }
}
