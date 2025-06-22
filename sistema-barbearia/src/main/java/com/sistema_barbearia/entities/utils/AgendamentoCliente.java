package com.sistema_barbearia.entities.utils;

import com.sistema_barbearia.entities.Barbeiro;
import jakarta.persistence.Embeddable;

import java.time.LocalDateTime;

@Embeddable
public class AgendamentoCliente {
    private LocalDateTime horario;
    private String nomeBarbeiro;

    public AgendamentoCliente(){}
    public AgendamentoCliente(LocalDateTime horario, Barbeiro barbeiro) {
        this.horario = horario;
        this.nomeBarbeiro = barbeiro.getUser().getNome();
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }

    public String getNomeBarbeiro() {
        return nomeBarbeiro;
    }

    public void setNomeBarbeiro(String nomeBarbeiro) {
        this.nomeBarbeiro = nomeBarbeiro;
    }
}
