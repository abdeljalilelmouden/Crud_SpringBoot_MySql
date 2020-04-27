package org.sid.stagiaire;


import java.util.Date;

import org.sid.stagiaire.dao.StagiaireRepository;
import org.sid.stagiaire.entities.Stagiaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StagiaireApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(StagiaireApplication.class, args);
	}
	@Autowired
	private StagiaireRepository stagiaireRepository;
	@Override
	public void run(String... args) throws Exception {
		
 
		stagiaireRepository.save( new Stagiaire(null, "khadija", "ABDELJALIL", new Date()) );
		stagiaireRepository.save( new Stagiaire(null, "ali ali", "alami", new Date()) );
		stagiaireRepository.save( new Stagiaire(null, "naima", "jamali", new Date()) );
	}

}
