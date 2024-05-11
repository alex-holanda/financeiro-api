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

    @Value("${receita.listarPorContabilidadeId}")
    private String listarPorContabilidadeId;

    @Override
    public List<Receita> listarPorContabilidadeId(Long contabilidadeId) {
        return jdbcClient
                .sql(listarPorContabilidadeId)
                .param("contabilidadeId", contabilidadeId)
                .query(Receita.class)
                .list();
    }
}
