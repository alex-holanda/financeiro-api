package br.dev.holanda.financeiro.domain.repository;

import br.dev.holanda.financeiro.domain.model.Receita;

import java.util.List;

public interface ReceitaRepository {

    List<Receita> listarPorCriadoPor(String criadoPor);
}
