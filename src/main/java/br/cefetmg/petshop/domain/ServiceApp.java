package br.cefetmg.petshop.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "service")
public class ServiceApp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Tipo é campo obrigatório para inserir ou modificar um SERVICE")
    @Column(nullable = false, length = 50)
    private String tipo;

    @NotEmpty
    @Column(nullable = false, length = 70)
    private String descricao;

    @NotNull
    @Column(nullable = false, length = 70)
    private float valor;

}
