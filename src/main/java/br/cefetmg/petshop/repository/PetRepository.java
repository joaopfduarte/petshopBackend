package br.cefetmg.petshop.repository;

import br.cefetmg.petshop.domain.Pet;
import org.hibernate.annotations.processing.SQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    List<Pet> findByNomeContaining(String nome);
}
