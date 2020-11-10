package br.com.grupomultiplica.backend.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.grupomultiplica.backend.api.domain.Registry;

@Repository
public interface RegistryRepository extends JpaRepository<Registry, Long> {

}
