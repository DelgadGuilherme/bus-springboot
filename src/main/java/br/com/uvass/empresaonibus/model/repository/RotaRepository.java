package br.com.uvass.empresaonibus.model.repository;

import br.com.uvass.empresaonibus.model.entity.Rota;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RotaRepository {

    private JdbcTemplate jdbcTemplate;

    public RotaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Rota> buscarTodos() {
        String sql = "select * from rota";

        return jdbcTemplate.query(sql, new RotaMapper());
    }

    public Rota buscar(int id){
        String sql = "select * from rota where id = ?";

        return jdbcTemplate.queryForObject(sql, new RotaMapper(), id);
    }

    public List<LocalTime> retornarHorario(int id) {
        Rota rota = this.buscar(id);
        List horario = new ArrayList();
        horario.add(rota.getHorario_chegada_terminal());
        horario.add(rota.getHorario_saida_terminal());
        return horario;
    }

    public Rota insert(Rota rota) throws Exception {
        String sql = "insert into rota (id, horario_saida_terminal, horario_chegada_terminal, ponto_id) values (?,?,?,?)";

        int insert = jdbcTemplate.update(sql, rota.getId(), rota.getHorario_saida_terminal(), rota.getHorario_chegada_terminal(), rota.getId_ponto());

        if (insert == 1){
            return rota;
        }
        throw new Exception("A rota nao foi inserida");
    }

    public Rota favoritarRota(int id, int usuario_id) throws Exception{
        String sql = "insert into rotaFavorita (usuario_id, rota_id) values(?,?)";
        Rota rota = buscar(id);
        int insert = jdbcTemplate.update(sql, usuario_id, id);

        if (insert == 1){
            return rota;
        }

        throw new Exception("A rota não foi favoritada");
    }

}
