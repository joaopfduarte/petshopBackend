package br.cefetmg.petshop.controller;

import br.cefetmg.petshop.domain.ServiceApp;
import br.cefetmg.petshop.repository.ServiceRepository;
import br.cefetmg.petshop.service.ServiceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/service")
public class ServiceController {

    @Autowired
    private final ServiceService serviceService;

    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceApp> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(serviceService.getById(id));
    }

    @GetMapping({ "", "/" })
    public ResponseEntity<List<ServiceApp>> getAll() {
        return ResponseEntity.ok().body(serviceService.getAll());
    }

    @GetMapping({ "/searchText/{searchText}" })
    public ResponseEntity<List<ServiceApp>> getBySearchText(@PathVariable String searchText) {
        return ResponseEntity.ok().body(serviceService.getBySearchText(searchText));
    }

    @GetMapping({ "/searchText", "/searchText/" })
    public ResponseEntity<List<ServiceApp>> getBySearchText() {
        return ResponseEntity.ok().body(new ArrayList<>());
    }

    @PostMapping({ "", "/" })
    public ResponseEntity<ServiceApp> create(@Valid @RequestBody ServiceApp service) {
        service = serviceService.create(service);
        return ResponseEntity.ok().body(service);
    }

    @PutMapping({ "", "/" })
    public ResponseEntity<ServiceApp> update(@Valid @RequestBody ServiceApp service) {
        service = serviceService.update(service);
        return ResponseEntity.ok().body(service);
    }

    @Autowired
    private ServiceRepository serviceRepository;

    @DeleteMapping("/{id}")
    public ResponseEntity<ServiceApp> update(@PathVariable Long id) {
        ServiceApp service = serviceService.delete(id);
        return ResponseEntity.ok().body(service);
    }

    @GetMapping("/teste")
    public String teste() {
        return "Teste";
    }
}
