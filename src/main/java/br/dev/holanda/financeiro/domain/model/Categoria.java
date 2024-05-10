package br.dev.holanda.financeiro.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Categoria {

    private Long id;
    private String nome;
    private String descricao;
}
