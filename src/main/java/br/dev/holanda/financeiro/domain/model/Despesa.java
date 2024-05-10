package br.dev.holanda.financeiro.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class Despesa {

    private Long id;
    private Banco banco;
    private String nome;
    private String descricao;
    private BigDecimal valor;
    private DespesaTipo tipo;
    private Date gastoEm;
    private Categoria categoria;
    private Boolean pago;
    private Integer numeroParcela;
    private FormaPagamento formaPagamento;
    private Boolean recorrente;
    private RecorrenciaTipo recorrenteTipo;
}
