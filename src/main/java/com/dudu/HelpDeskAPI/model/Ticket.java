package com.dudu.HelpDeskAPI.model;

import com.dudu.HelpDeskAPI.enums.Categoria;
import com.dudu.HelpDeskAPI.enums.Prioridade;
import com.dudu.HelpDeskAPI.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Ticket {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String titulo;
    private String descricao;
    private Instant dataDeCriacao;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @OneToOne()
    @JoinColumn(name = "id_solicitante")
    private User solicitante;
    private User responsavel;


}
