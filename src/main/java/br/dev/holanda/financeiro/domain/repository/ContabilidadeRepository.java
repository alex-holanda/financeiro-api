package br.dev.holanda.financeiro.domain.repository;

import br.dev.holanda.financeiro.domain.model.Contabilidade;

import java.util.List;

public interface ContabilidadeRepository {

    List<Contabilidade> buscarPorCriadoPor(String criadoPor);

}
