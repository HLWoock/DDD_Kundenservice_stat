package de.woock;

import static de.woock.domain.Abteilungen.Fuhrpark;
import static de.woock.domain.Abteilungen.Verein;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import de.woock.domain.Anfrage;
import de.woock.domain.AnfragenOrdner;
import de.woock.domain.AnfragenBoard;

@SpringBootApplication
public class Kundenservice {
	
	public static AnfragenOrdner anfragenOrdner;
	public static AnfragenBoard  anfragenBoard;

	public static void main(String[] args) {
		SpringApplication.run(Kundenservice.class, args);
	}
	
	@Bean
	public ApplicationRunner test(AnfragenOrdner anfragenOrdner, AnfragenBoard anfragenBoard) {
		return args -> {
			Kundenservice.anfragenOrdner = anfragenOrdner;
			Kundenservice.anfragenBoard  = anfragenBoard;
			
			new Anfrage().stellen("Wann kommen endlich die versprochenen Jetski?")
			             .weiterleitenAn(Fuhrpark)
			             .beantworten("In 2 Wochen");
			
			new Anfrage().stellen("Was kostet die Mitgliedschaft fuer ein Jahr?")
			             .weiterleitenAn(Verein)
			             .beantworten("50 Euro");
		};
	}

}
