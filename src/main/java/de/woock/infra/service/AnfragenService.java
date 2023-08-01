package de.woock.infra.service;

import java.util.List;

import org.springframework.stereotype.Service;

import de.woock.domain.Anfrage;

@Service
public class AnfragenService {

	public List<Anfrage>alleAnfragen() {
		return Anfrage.liste();
	}
}
