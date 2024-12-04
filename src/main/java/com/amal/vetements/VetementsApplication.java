package com.amal.vetements;

import com.amal.vetements.entities.Boutique;
import com.amal.vetements.entities.Vetement;
import com.amal.vetements.service.VetementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class VetementsApplication implements CommandLineRunner{
	@Autowired
    VetementService vetementService;
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(VetementsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Vetement.class);
		repositoryRestConfiguration.exposeIdsFor(Boutique.class);

	}

}
