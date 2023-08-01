package de.woock.domain;

import java.util.List;

import org.springframework.stereotype.Service;

import de.woock.infra.repository.Anfragen;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AnfragenOrdner {
	
	private Anfragen anfragen;

	public Anfrage abheften(Anfrage anfrage) {
		return anfragen.hinzufuegen(anfrage);
	}

	public void updaten(Anfrage anfrage) {
		anfragen.hinzufuegen(anfrage);		
	}
	
	public List<Anfrage> alleAnfragen() {
		return anfragen.alle();
	}

}
