package com.sipakal.safeosms.repository;

import com.sipakal.safeosms.domain.SistemaMsjLargo;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the SistemaMsjLargo entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SistemaMsjLargoRepository extends JpaRepository<SistemaMsjLargo, Long> {

}
