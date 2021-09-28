package br.com.uvass.empresaonibus.model.repository;

import br.com.uvass.empresaonibus.model.entity.Usuario;
import org.springframework.jdbc.core.JdbcTemplate;

public class UsuarioRepository {

    private JdbcTemplate jdbcTemplate;

    public UsuarioRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public Usuario inserir(Usuario usuario) throws Exception {
        String sql = "insert into usuario(id, nome, email, telefone, cpf, endereco_id) values (?,?,?,?,?,?)";
        int insert = jdbcTemplate.update(sql,
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTelefone(),
                usuario.getCpf(),
                usuario.getEndereco_id());

        if(insert == 1) {
            return usuario;
        }
        throw new Exception("O usuario nao foi inserido");
    }
}
