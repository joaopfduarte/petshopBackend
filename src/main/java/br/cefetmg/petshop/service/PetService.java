package br.cefetmg.petshop.service;

import br.cefetmg.petshop.domain.Pet;
import br.cefetmg.petshop.repository.PetRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PetService {

    private final PetRepository petRepository;

    public Pet getById(Long id){
        Pet pet = petRepository.findById(id).orElse(null);
        if (pet == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pet não encontrado");
        }

        return pet;
    }

    public Pet create(Pet pet){
        if (pet != null && pet.getId() != null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id não deve ser informado");
        }

        pet = petRepository.save(pet);
        return pet;
    }

    public List<Pet> getAll() {
        return petRepository.findAll();
    }

    public Pet update(Pet pet) {
        if (pet != null && pet.getId() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id deve ser informado");
        }

        pet = petRepository.save(pet);
        return pet;
    }

    public Pet delete(Long id) {
        Pet pet = this.getById(id);
        if (pet == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pet ("+id+") não encontrado para exclusão.");
        }

        petRepository.delete(pet);
        return pet;
    }

    public List<Pet> getBySearchText(String searchText) {
        List<Pet> petList = petRepository.findByNomeContaining(searchText);
        if (petList == null){
            petList = new ArrayList<>();
        }

        return petList;
    }
}
