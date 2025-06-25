package com.dudu.HelpDeskAPI.model;

import com.dudu.HelpDeskAPI.enums.Perfil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data @NoArgsConstructor @AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String senha;

    @Enumerated(EnumType.STRING)
    private Perfil perfil;

    @OneToMany(mappedBy = "solicitante", cascade = CascadeType.ALL)
    private List<Ticket> ticketsCriados = new ArrayList<>();

    @OneToMany(mappedBy = "responsavel", cascade = CascadeType.ALL)
    private List<Ticket> ticketsResponsavel = new ArrayList<>();
}
