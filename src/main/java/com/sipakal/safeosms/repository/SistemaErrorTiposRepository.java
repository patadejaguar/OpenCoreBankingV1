package com.sipakal.safeosms.repository;

import com.sipakal.safeosms.domain.SistemaErrorTipos;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the SistemaErrorTipos entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SistemaErrorTiposRepository extends JpaRepository<SistemaErrorTipos, Long> {

}
