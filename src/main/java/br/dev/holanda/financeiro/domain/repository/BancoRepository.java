package br.dev.holanda.financeiro.domain.repository;

import java.math.BigDecimal;

public interface BancoRepository {

    BigDecimal buscarSaldo(String criadoPor);
}
