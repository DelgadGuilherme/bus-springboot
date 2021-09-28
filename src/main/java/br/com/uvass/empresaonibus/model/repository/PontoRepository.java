package br.com.uvass.empresaonibus.model.repository;

import br.com.uvass.empresaonibus.model.entity.Ponto;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class PontoRepository {

    private JdbcTemplate jdbcTemplate;

    public PontoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Ponto inserir(Ponto ponto) throws Exception {
        String sql = "insert into ponto(id, localizacao) values (?,?)";

        int insert = jdbcTemplate.update(sql, ponto.getId(), ponto.getLocalizacao());

        if(insert == 1) {
            return ponto;
        }
        throw new Exception("O ponto não foi inserido");
    }

    public Ponto retornar(int id){
        String sql = "select * from ponto where id = ?";

        return jdbcTemplate.queryForObject(sql,new PontoMapper(), id);
    }

    public String retornarLocalizacao(int id){
        Ponto ponto = this.retornar(id);

        return ponto.getLocalizacao();
    }
}
