package com.sipakal.safeosms.repository;

import com.sipakal.safeosms.domain.SistemaErrorLog;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the SistemaErrorLog entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SistemaErrorLogRepository extends JpaRepository<SistemaErrorLog, Long> {

}
