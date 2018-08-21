package com.sipakal.safeosms.service;

import com.sipakal.safeosms.service.dto.SistemaErrorTiposDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing SistemaErrorTipos.
 */
public interface SistemaErrorTiposService {

    /**
     * Save a sistemaErrorTipos.
     *
     * @param sistemaErrorTiposDTO the entity to save
     * @return the persisted entity
     */
    SistemaErrorTiposDTO save(SistemaErrorTiposDTO sistemaErrorTiposDTO);

    /**
     * Get all the sistemaErrorTipos.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<SistemaErrorTiposDTO> findAll(Pageable pageable);

    /**
     * Get the "id" sistemaErrorTipos.
     *
     * @param id the id of the entity
     * @return the entity
     */
    SistemaErrorTiposDTO findOne(Long id);

    /**
     * Delete the "id" sistemaErrorTipos.
     *
     * @param id the id of the entity
     */
    void delete(Long id);

    /**
     * Search for the sistemaErrorTipos corresponding to the query.
     *
     * @param query the query of the search
     * 
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<SistemaErrorTiposDTO> search(String query, Pageable pageable);
}
