package com.sipakal.safeosms.repository;

import com.sipakal.safeosms.domain.SistemaConfiguracion;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the SistemaConfiguracion entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SistemaConfiguracionRepository extends JpaRepository<SistemaConfiguracion, Long> {

}
