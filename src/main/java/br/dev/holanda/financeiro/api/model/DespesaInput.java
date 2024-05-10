package br.dev.holanda.financeiro.api.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class DespesaInput {

    private String nmDescricao;
    private String tipo;
    private Date dtGastoEm;
    private CategoriaInput categoria;
    private Integer nrQuantidadeParcela;
    private Boolean pago;
    private BigDecimal vlParcela;
    private Boolean inRecorrencia;
    private String nmRecorrencia;

}
