package com.sipakal.safeosms.repository;

import com.sipakal.safeosms.domain.SistemaNivelRiesgo;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the SistemaNivelRiesgo entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SistemaNivelRiesgoRepository extends JpaRepository<SistemaNivelRiesgo, Long> {

}
