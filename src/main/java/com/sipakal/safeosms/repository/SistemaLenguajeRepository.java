package com.sipakal.safeosms.repository;

import com.sipakal.safeosms.domain.SistemaLenguaje;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the SistemaLenguaje entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SistemaLenguajeRepository extends JpaRepository<SistemaLenguaje, Long> {

}
