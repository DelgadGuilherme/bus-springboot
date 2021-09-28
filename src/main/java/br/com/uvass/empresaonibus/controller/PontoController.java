package br.com.uvass.empresaonibus.controller;

import br.com.uvass.empresaonibus.model.entity.Ponto;
import br.com.uvass.empresaonibus.model.repository.PontoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ponto")
public class PontoController {

    private PontoRepository pontoRepository;

    public PontoController(JdbcTemplate jdbcTemplate) {
        pontoRepository = new PontoRepository(jdbcTemplate);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Ponto inserir(@RequestBody Ponto ponto) throws Exception{
        return pontoRepository.inserir(ponto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/localizacao/{id}")
    public String retornarLocalizacao(@PathVariable int id){
        return pontoRepository.retornarLocalizacao(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Ponto retornar(@PathVariable int id){
        return pontoRepository.retornar(id);
    }
}
