package br.dev.holanda.financeiro.domain.repository;

import br.dev.holanda.financeiro.domain.model.Categoria;

import java.util.List;

public interface CategoriaRepository {

    List<Categoria> listar();

    Categoria buscarPorId(Long categoriaId);

    Long cadastrar(Categoria categoria);

    Long atualizar(Long categoriaId, Categoria categoria);

}
