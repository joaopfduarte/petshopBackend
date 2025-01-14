package br.cefetmg.petshop.controller;

import br.cefetmg.petshop.domain.Pet;
import br.cefetmg.petshop.service.PetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/pet")
public class PetController {

    @Autowired
    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(petService.getById(id));
    }

    @GetMapping({ "", "/" })
    public ResponseEntity<List<Pet>> getAll() {
        return ResponseEntity.ok().body(petService.getAll());
    }

    @GetMapping({ "/searchText/{searchText}" })
    public ResponseEntity<List<Pet>> getBySearchText(@PathVariable String searchText) {
        return ResponseEntity.ok().body(petService.getBySearchText(searchText));
    }

    @GetMapping({ "/searchText", "/searchText/" })
    public ResponseEntity<List<Pet>> getBySearchText() {
        return ResponseEntity.ok().body(new ArrayList<>());
    }

    @PostMapping({ "", "/" })
    public ResponseEntity<Pet> create(@Valid @RequestBody Pet pet) {
        pet = petService.create(pet);
        return ResponseEntity.ok().body(pet);
    }

    @PutMapping({ "", "/" })
    public ResponseEntity<Pet> update(@Valid @RequestBody Pet pet) {
        pet = petService.update(pet);
        return ResponseEntity.ok().body(pet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pet> update(@PathVariable Long id) {
        Pet pet = petService.delete(id);
        return ResponseEntity.ok().body(pet);
    }

    @GetMapping("/teste")
    public String teste() {
        return "Teste";
    }
}
