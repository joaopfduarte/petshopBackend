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
@Entity(name = "pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Nome é campo obrigatório para inserir ou modificar um PET")
    @Column(nullable = false, length = 50)
    private String nome;

    @NotEmpty
    @Column(nullable = false, length = 70)
    private String dono;

}
