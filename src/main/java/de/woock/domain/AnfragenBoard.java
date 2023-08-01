package de.woock.domain;

import org.springframework.stereotype.Service;

import de.woock.infra.message.Ausgang;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AnfragenBoard {
	
	private Ausgang ausgang;

	public void neueAnfrageAnheften(Anfrage anfrage, Abteilungen abteilung) {
		ausgang.neueAnfrageFuerAbteilung(anfrage, abteilung);
	}

}
