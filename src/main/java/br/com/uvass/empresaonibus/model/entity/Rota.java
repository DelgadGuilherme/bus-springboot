package br.com.uvass.empresaonibus.model.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Rota {
    private int id;
    private LocalTime horario_saida_terminal;
    private LocalTime horario_chegada_terminal;
    private int id_ponto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalTime getHorario_saida_terminal() {
        return horario_saida_terminal;
    }

    public void setHorario_saida_terminal(LocalTime horario_saida_terminal) {
        this.horario_saida_terminal = horario_saida_terminal;
    }

    public LocalTime getHorario_chegada_terminal() {
        return horario_chegada_terminal;
    }

    public void setHorario_chegada_terminal(LocalTime horario_chegada_terminal) {
        this.horario_chegada_terminal = horario_chegada_terminal;
    }

    public int getId_ponto() {
        return id_ponto;
    }

    public void setId_ponto(int id_ponto) {
        this.id_ponto = id_ponto;
    }
}
