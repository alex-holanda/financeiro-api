package br.dev.holanda.financeiro.infrastructure.repository;

import br.dev.holanda.financeiro.domain.repository.BancoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
@RequiredArgsConstructor
@PropertySource("classpath:query/banco.jdbc.properties")
public class BancoRepositoryImpl implements BancoRepository {

    private final JdbcClient jdbcClient;

    @Value("${banco.buscarSaldo}")
    private String buscarSaldo;

    @Override
    public BigDecimal buscarSaldo(String criadoPor) {
        return jdbcClient
                .sql(buscarSaldo)
                .query(BigDecimal.class)
                .single();
    }
}
