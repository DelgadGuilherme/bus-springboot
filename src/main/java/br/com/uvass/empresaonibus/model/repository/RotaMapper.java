package br.com.uvass.empresaonibus.model.repository;

import br.com.uvass.empresaonibus.model.entity.Rota;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RotaMapper implements RowMapper<Rota> {

    @Override
    public Rota mapRow(ResultSet rs, int i) throws SQLException {
        Rota rota = new Rota();
        rota.setId(rs.getInt("id"));
        rota.setHorario_chegada_terminal(rs.getTime("horario_chegada_terminal").toLocalTime());
        rota.setHorario_saida_terminal(rs.getTime("horario_saida_terminal").toLocalTime());
        rota.setId_ponto(rs.getInt("ponto_id"));

        return rota;
    }

}
