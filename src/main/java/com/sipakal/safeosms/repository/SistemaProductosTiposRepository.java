package com.sipakal.safeosms.repository;

import com.sipakal.safeosms.domain.SistemaProductosTipos;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the SistemaProductosTipos entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SistemaProductosTiposRepository extends JpaRepository<SistemaProductosTipos, Long> {

}
