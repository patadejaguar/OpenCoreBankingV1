package com.sipakal.safeosms.repository;

import com.sipakal.safeosms.domain.SistemaCatalogoInterno;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the SistemaCatalogoInterno entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SistemaCatalogoInternoRepository extends JpaRepository<SistemaCatalogoInterno, Long> {

}
