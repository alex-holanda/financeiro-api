package br.dev.holanda.financeiro.infrastructure.repository;

import br.dev.holanda.financeiro.domain.model.Despesa;
import br.dev.holanda.financeiro.domain.repository.DespesaRepository;
import br.dev.holanda.financeiro.infrastructure.mapper.DespesaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@PropertySource("classpath:query/despesa.jdbc.properties")
public class DespesaRepositoryImpl implements DespesaRepository {

    private final JdbcClient jdbcClient;

    private final DespesaMapper despesaMapper;

    @Value("${despesa.listar-por-criado-por}")
    private String listarPorCriadoPor;

    @Override
    public List<Despesa> listarPorCriadoPor(String criadoPor) {
        return jdbcClient
                .sql(listarPorCriadoPor)
                .param("criadoPor", criadoPor)
                .query(despesaMapper)
                .list();
    }
}
