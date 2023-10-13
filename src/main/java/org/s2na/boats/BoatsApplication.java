package org.s2na.boats;

import org.s2na.boats.domain.Boat;
import org.s2na.boats.domain.Classe;
import org.s2na.boats.repository.BoatRepository;
import org.s2na.boats.repository.ClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BoatsApplication implements CommandLineRunner {

	@Autowired
	private BoatRepository boatRepository;
	@Autowired
	private ClasseRepository classeRepository;

	public static void main(String[] args) {
		SpringApplication.run(BoatsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		boatRepository.deleteAll();
		boatRepository.flush();
		classeRepository.deleteAll();
		classeRepository.flush();
		Classe c1 = new Classe();
		c1.setName("Navire de combat");
		classeRepository.saveAndFlush(c1);
		Classe c2 = new Classe();
		c2.setName("Navire de plaisance");
		classeRepository.saveAndFlush(c2);

		Boat b1 = new Boat();
		b1.setName("Jeanne d'Arc");
		b1.setClasse(c2);
		boatRepository.saveAndFlush(b1);
		Boat b2 = new Boat();
		b2.setName("Jean Bar");
		b2.setTonnage(100);
		b2.setLength(70F);
		b2.setClasse(c1);
		boatRepository.saveAndFlush(b2);
	}

}
