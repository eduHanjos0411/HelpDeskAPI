package com.dudu.HelpDeskAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Ticket {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    private String titulo;
    private String descricao;
    private Instant dataDeCriacao;
    private Status status;
    private Prioridade prioridade;
    private String categoria;
    private User solicitante;
    private User responsavel;


}
