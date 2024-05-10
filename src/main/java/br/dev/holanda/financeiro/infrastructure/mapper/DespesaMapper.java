package br.dev.holanda.financeiro.infrastructure.mapper;

import br.dev.holanda.financeiro.domain.model.*;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class DespesaMapper implements RowMapper<Despesa> {

    @Override
    public Despesa mapRow(ResultSet rs, int rowNum) throws SQLException {
        var categoria = new Categoria();
        categoria.setId(rs.getLong("id_categoria"));
        categoria.setNome(rs.getString("categoria_nome"));
        categoria.setDescricao(rs.getString("categoria_descricao"));

        var banco = new Banco();
        banco.setId(rs.getLong("id_banco"));
        banco.setNome(rs.getString("banco_nome"));

        var despesa = new Despesa();
        despesa.setId(rs.getLong("id"));
        despesa.setCategoria(categoria);
        despesa.setBanco(banco);
        despesa.setNome(rs.getString("nome"));
        despesa.setDescricao(rs.getString("descricao"));
        despesa.setValor(rs.getBigDecimal("valor"));
        despesa.setTipo(DespesaTipo.valueOf(rs.getString("tipo")));
        despesa.setGastoEm(rs.getDate("gasto_em"));
        despesa.setPago(rs.getBoolean("pago"));
        despesa.setNumeroParcela(rs.getInt("numero_parcela"));
        despesa.setFormaPagamento(FormaPagamento.valueOf(rs.getString("forma_pagamento")));
        despesa.setRecorrente(rs.getBoolean("recorrente"));
//        despesa.setRecorrenteTipo(RecorrenciaTipo.valueOf(rs.getString("recorrente_tipo")));

        return despesa;
    }
}
