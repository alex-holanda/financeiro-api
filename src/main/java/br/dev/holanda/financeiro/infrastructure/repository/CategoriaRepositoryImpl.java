package br.dev.holanda.financeiro.infrastructure.repository;

import br.dev.holanda.financeiro.domain.model.Categoria;
import br.dev.holanda.financeiro.domain.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@PropertySource("classpath:query/categoria.jdbc.properties")
public class CategoriaRepositoryImpl implements CategoriaRepository {

    private final JdbcClient jdbcClient;

    @Value("${categoria.listar}")
    private String listar;

    @Value("${categoria.buscarPorId}")
    private String buscarPorId;

    @Value("${categoria.inserir}")
    private String inserir;

    @Value("${categoria.atualizar}")
    private String atualizar;


    @Override
    public List<Categoria> listar() {
        return jdbcClient
                .sql(listar)
                .query(Categoria.class)
                .list();
    }

    @Override
    public Categoria buscarPorId(Long categoriaId) {
        return jdbcClient
                .sql(buscarPorId)
                .param("categoriaId", categoriaId)
                .query(Categoria.class)
                .single();
    }

    @Override
    public Long cadastrar(Categoria categoria) {
        var keyHolder = new GeneratedKeyHolder();

        jdbcClient
                .sql(inserir)
                .param("nome", categoria.getNome())
                .param("descricao", categoria.getDescricao())
                .update(keyHolder, new String[] { "id" });

        return keyHolder.getKey().longValue();
    }

    @Override
    public Long atualizar(Long categoriaId, Categoria categoria) {
        var keyHolder = new GeneratedKeyHolder();

        jdbcClient
                .sql(atualizar)
                .param("categoriaId", categoriaId)
                .param("nome", categoria.getNome())
                .param("descricao", categoria.getDescricao())
                .update(keyHolder, new String[] { "id" });

        return keyHolder.getKey().longValue();
    }
}
