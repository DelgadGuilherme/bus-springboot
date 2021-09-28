package br.com.uvass.empresaonibus.controller;

import br.com.uvass.empresaonibus.model.entity.Usuario;
import br.com.uvass.empresaonibus.model.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioRepository usuarioRepository;

    public UsuarioController(JdbcTemplate jdbcTemplate) {
        usuarioRepository = new UsuarioRepository(jdbcTemplate);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Usuario inserir(@RequestBody Usuario usuario) throws Exception {
        return usuarioRepository.inserir(usuario);
    }

}
