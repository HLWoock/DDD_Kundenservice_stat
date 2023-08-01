package de.woock.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.woock.domain.Anfrage;

public interface AnfragenRepository extends JpaRepository<Anfrage, Long> {
}
