package br.dev.holanda.financeiro.domain.repository;

import br.dev.holanda.financeiro.domain.model.Despesa;

import java.util.List;

public interface DespesaRepository {

    List<Despesa> listarPorCriadoPor(String criadoPor);
}
