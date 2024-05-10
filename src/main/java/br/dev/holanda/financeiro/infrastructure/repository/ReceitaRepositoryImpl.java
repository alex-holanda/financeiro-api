package br.dev.holanda.financeiro.infrastructure.repository;

import br.dev.holanda.financeiro.domain.model.Receita;
import br.dev.holanda.financeiro.domain.repository.ReceitaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@PropertySource("classpath:query/receita.jdbc.properties")
public class ReceitaRepositoryImpl implements ReceitaRepository {

    private final JdbcClient jdbcClient;

    @Value("${receita.listarPorCriadoPor}")
    private String listarPorCriadoPor;

    @Override
    public List<Receita> listarPorCriadoPor(String criadoPor) {
        return jdbcClient
                .sql(listarPorCriadoPor)
                .param("criadoPor", criadoPor)
                .query(Receita.class)
                .list();
    }
}
