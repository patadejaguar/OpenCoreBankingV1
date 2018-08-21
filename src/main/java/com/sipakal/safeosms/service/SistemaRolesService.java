package com.sipakal.safeosms.service;

import com.sipakal.safeosms.service.dto.SistemaRolesDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing SistemaRoles.
 */
public interface SistemaRolesService {

    /**
     * Save a sistemaRoles.
     *
     * @param sistemaRolesDTO the entity to save
     * @return the persisted entity
     */
    SistemaRolesDTO save(SistemaRolesDTO sistemaRolesDTO);

    /**
     * Get all the sistemaRoles.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<SistemaRolesDTO> findAll(Pageable pageable);

    /**
     * Get the "id" sistemaRoles.
     *
     * @param id the id of the entity
     * @return the entity
     */
    SistemaRolesDTO findOne(Long id);

    /**
     * Delete the "id" sistemaRoles.
     *
     * @param id the id of the entity
     */
    void delete(Long id);

    /**
     * Search for the sistemaRoles corresponding to the query.
     *
     * @param query the query of the search
     * 
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<SistemaRolesDTO> search(String query, Pageable pageable);
}
