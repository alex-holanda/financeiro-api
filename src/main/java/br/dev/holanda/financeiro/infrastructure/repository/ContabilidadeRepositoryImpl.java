package br.dev.holanda.financeiro.infrastructure.repository;

import br.dev.holanda.financeiro.domain.model.Contabilidade;
import br.dev.holanda.financeiro.domain.repository.ContabilidadeRepository;
import br.dev.holanda.financeiro.domain.repository.DespesaRepository;
import br.dev.holanda.financeiro.domain.repository.ReceitaRepository;
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

    private final DespesaRepository despesaRepository;
    private final ReceitaRepository receitaRepository;

    @Value("${contabilidade.consultar-por-criado-por}")
    private String buscarPorCriadoPor;

    @Override
    public List<Contabilidade> buscarPorCriadoPor(String criadoPor) {
        var contabilidades = jdbcClient
                .sql(buscarPorCriadoPor)
                .param("criadoPor", criadoPor)
                .query(Contabilidade.class)
                .list();

        contabilidades.forEach(contabilidade -> {
            var contabilidadeId = contabilidade.getId();
            contabilidade.setDespesas(despesaRepository.listarPorContabilidadeId(contabilidadeId));
            contabilidade.setReceitas(receitaRepository.listarPorContabilidadeId(contabilidadeId));
        });

        return contabilidades;
    }
}
