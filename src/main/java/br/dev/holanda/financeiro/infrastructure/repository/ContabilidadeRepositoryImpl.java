package br.dev.holanda.financeiro.infrastructure.repository;

import br.dev.holanda.financeiro.domain.model.Contabilidade;
import br.dev.holanda.financeiro.domain.repository.ContabilidadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@PropertySource("classpath:query/contabilidade.jdbc.properties")
public class ContabilidadeRepositoryImpl implements ContabilidadeRepository {

    private final JdbcClient jdbcClient;

    @Value("${contabilidade.consultar-por-criado-por}")
    private String buscarPorCriadoPor;

    @Override
    public List<Contabilidade> buscarPorCriadoPor(String criadoPor) {
        return jdbcClient
                .sql(buscarPorCriadoPor)
                .param("criadoPor", criadoPor)
                .query(Contabilidade.class)
                .list();
    }
}
