package com.sipakal.safeosms.repository;

import com.sipakal.safeosms.domain.SistemaComCanales;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the SistemaComCanales entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SistemaComCanalesRepository extends JpaRepository<SistemaComCanales, Long> {

}
