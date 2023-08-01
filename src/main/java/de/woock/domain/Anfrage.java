package de.woock.domain;

import static de.woock.domain.Status.AUFGENOMMEN;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import de.woock.Kundenservice;
import de.woock.infra.entity.Kopfdaten;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@SuppressWarnings({ "serial" })
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Anfrage extends Kopfdaten implements Serializable {

	                             private String anfrage;
	                             private String antwort;
	                             private Date   von;
	@Enumerated(EnumType.STRING) private Status status;
	
	public Anfrage(String text) {
		this.anfrage = text;
	}

	public Anfrage stellen(String anfrage) {
		this.anfrage = anfrage;
		this.von     = new Date();
		this.status  = AUFGENOMMEN;
		return Kundenservice.anfragenOrdner.abheften(this);	
	}

	public Anfrage weiterleitenAn(Abteilungen fuhrpark) {
		Kundenservice.anfragenBoard.neueAnfrageAnheften(this, fuhrpark);
		return this;
	}

	public void beantworten(String antwort) {
		this.antwort = antwort;
		Kundenservice.anfragenOrdner.updaten(this);
	}
	
	public static List<Anfrage> liste() {
		return Kundenservice.anfragenOrdner.alleAnfragen();
	}
}
