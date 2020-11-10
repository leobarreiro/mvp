package br.com.grupomultiplica.backend.api.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.grupomultiplica.backend.api.domain.Registry;
import br.com.grupomultiplica.backend.api.repository.RegistryRepository;

@Configuration
@EnableJpaRepositories(basePackageClasses = RegistryRepository.class)
@EntityScan(basePackageClasses = Registry.class)
public class JpaConfig {

}
