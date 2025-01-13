package br.cefetmg.petshop.repository;

import br.cefetmg.petshop.domain.ServiceApp;
import org.hibernate.annotations.processing.SQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceApp, Long> {

    List<ServiceApp> findByNomeContaining(String tipo);
}
