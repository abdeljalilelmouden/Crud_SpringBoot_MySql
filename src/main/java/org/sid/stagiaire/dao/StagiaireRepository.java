package org.sid.stagiaire.dao;

import org.sid.stagiaire.entities.Stagiaire;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StagiaireRepository extends JpaRepository<Stagiaire, Long>{

	public Page<Stagiaire> findByNomContains(String mc, Pageable pageable);
}
