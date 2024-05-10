package br.dev.holanda.financeiro.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class Receita {

    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal valor;
    private Date recebidoEm;
}
