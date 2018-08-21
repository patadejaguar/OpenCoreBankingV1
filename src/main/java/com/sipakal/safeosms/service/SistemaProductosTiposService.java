package com.sipakal.safeosms.service;

import com.sipakal.safeosms.service.dto.SistemaProductosTiposDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing SistemaProductosTipos.
 */
public interface SistemaProductosTiposService {

    /**
     * Save a sistemaProductosTipos.
     *
     * @param sistemaProductosTiposDTO the entity to save
     * @return the persisted entity
     */
    SistemaProductosTiposDTO save(SistemaProductosTiposDTO sistemaProductosTiposDTO);

    /**
     * Get all the sistemaProductosTipos.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<SistemaProductosTiposDTO> findAll(Pageable pageable);

    /**
     * Get the "id" sistemaProductosTipos.
     *
     * @param id the id of the entity
     * @return the entity
     */
    SistemaProductosTiposDTO findOne(Long id);

    /**
     * Delete the "id" sistemaProductosTipos.
     *
     * @param id the id of the entity
     */
    void delete(Long id);

    /**
     * Search for the sistemaProductosTipos corresponding to the query.
     *
     * @param query the query of the search
     * 
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<SistemaProductosTiposDTO> search(String query, Pageable pageable);
}
