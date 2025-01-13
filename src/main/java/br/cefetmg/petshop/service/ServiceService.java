package br.cefetmg.petshop.service;

import br.cefetmg.petshop.domain.ServiceApp;
import br.cefetmg.petshop.repository.ServiceRepository;
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
public class ServiceService {

    private final ServiceRepository serviceRepository;

    public ServiceApp getById(Long id){
        ServiceApp service = serviceRepository.findById(id).orElse(null);
        if (service == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Service não encontrado");
        }

        return service;
    }

    public ServiceApp create(ServiceApp service){
        if (service != null && service.getId() != null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id não deve ser informado");
        }

        service = serviceRepository.save(service);
        return service;
    }

    public List<ServiceApp> getAll() {
        return serviceRepository.findAll();
    }

    public ServiceApp update(ServiceApp service) {
        if (service != null && service.getId() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id deve ser informado");
        }

        service = serviceRepository.save(service);
        return service;
    }

    public ServiceApp delete(Long id) {
        ServiceApp service = this.getById(id);
        if (service == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Service ("+id+") não encontrado para exclusão.");
        }

        serviceRepository.delete(service);
        return service;
    }

    public List<ServiceApp> getBySearchText(String searchText) {
        List<ServiceApp> serviceList = serviceRepository.findByNomeContaining(searchText);
        if (serviceList == null){
            serviceList = new ArrayList<>();
        }

        return serviceList;
    }
}
