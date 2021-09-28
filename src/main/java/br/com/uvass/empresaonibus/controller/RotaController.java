package br.com.uvass.empresaonibus.controller;

import br.com.uvass.empresaonibus.model.entity.Rota;
import br.com.uvass.empresaonibus.model.repository.RotaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/rota")
public class RotaController {

    private RotaRepository rotaRepository;

    public RotaController(JdbcTemplate jdbcTemplate) {
        rotaRepository = new RotaRepository(jdbcTemplate);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Rota inserir(@RequestBody Rota rota) throws Exception {
        return rotaRepository.insert(rota);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Rota buscarPorId(@PathVariable int id) {
        return rotaRepository.buscar(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/horario/{id}")
    public List<LocalTime> retornarHorario(@PathVariable int id){
        return rotaRepository.retornarHorario(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping ("/{id}/favoritar")
    public Rota favoritarRota(@PathVariable int id, @RequestParam int usuario_id)  throws Exception {
        return rotaRepository.favoritarRota(id, usuario_id);
    }
}
