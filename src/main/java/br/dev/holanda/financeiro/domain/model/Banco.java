package br.dev.holanda.financeiro.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Banco {

    private Long id;
    private String nome;
    private BigDecimal saldo;
}
