package com.sipakal.safeosms.repository;

import com.sipakal.safeosms.domain.SistemaRoles;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the SistemaRoles entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SistemaRolesRepository extends JpaRepository<SistemaRoles, Long> {

}
