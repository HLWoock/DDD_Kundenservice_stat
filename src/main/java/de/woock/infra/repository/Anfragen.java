package de.woock.infra.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import de.woock.domain.Anfrage;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Component
public class Anfragen {
	
	private final AnfragenRepository anfragenRepository;

	public Anfrage hinzufuegen(Anfrage anfrage) {
		return anfragenRepository.save(anfrage);
	}

	public List<Anfrage> alle() {
		return anfragenRepository.findAll();
	}
	
}
