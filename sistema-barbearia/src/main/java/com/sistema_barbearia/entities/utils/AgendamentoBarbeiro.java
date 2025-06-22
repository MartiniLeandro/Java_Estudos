package com.sistema_barbearia.entities.utils;

import com.sistema_barbearia.entities.Barbeiro;
import com.sistema_barbearia.entities.Cliente;
import jakarta.persistence.Embeddable;

import java.time.LocalDateTime;

@Embeddable
public class AgendamentoBarbeiro {
    private LocalDateTime horario;
    private String nomeCliente;

    public AgendamentoBarbeiro(){}
    public AgendamentoBarbeiro(LocalDateTime horario, Cliente cliente) {
        this.horario = horario;
        this.nomeCliente = cliente.getUser().getNome();
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }

    public String getNomeBarbeiro() {
        return nomeCliente;
    }

    public void setNomeBarbeiro(String nomeBarbeiro) {
        this.nomeCliente = nomeBarbeiro;
    }
}
