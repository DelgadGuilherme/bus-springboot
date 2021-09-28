package br.com.uvass.empresaonibus.model.repository;

import br.com.uvass.empresaonibus.model.entity.Ponto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PontoMapper implements RowMapper<Ponto> {

    @Override
    public Ponto mapRow(ResultSet rs, int i) throws SQLException {
        Ponto ponto = new Ponto();
        ponto.setId(rs.getInt("id"));
        ponto.setLocalizacao(rs.getString("localizacao"));

        return ponto;
    }
}
