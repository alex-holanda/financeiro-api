package br.dev.holanda.financeiro.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class Contabilidade {

    private Long id;
    private String mes;
    private String ano;

    private List<Despesa> despesas;
    private List<Receita> receitas;

    public BigDecimal getTotalReceitas() {
        return this.receitas
                .stream()
                .map(Receita::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getTotalDespesas() {
        return this.despesas
                .stream()
                .map(Despesa::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getSaldo() {
        return getTotalReceitas().subtract(getTotalDespesas());
    }
}
