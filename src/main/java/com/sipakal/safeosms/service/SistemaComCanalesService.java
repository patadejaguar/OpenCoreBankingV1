package com.sipakal.safeosms.service;

import com.sipakal.safeosms.service.dto.SistemaComCanalesDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing SistemaComCanales.
 */
public interface SistemaComCanalesService {

    /**
     * Save a sistemaComCanales.
     *
     * @param sistemaComCanalesDTO the entity to save
     * @return the persisted entity
     */
    SistemaComCanalesDTO save(SistemaComCanalesDTO sistemaComCanalesDTO);

    /**
     * Get all the sistemaComCanales.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<SistemaComCanalesDTO> findAll(Pageable pageable);

    /**
     * Get the "id" sistemaComCanales.
     *
     * @param id the id of the entity
     * @return the entity
     */
    SistemaComCanalesDTO findOne(Long id);

    /**
     * Delete the "id" sistemaComCanales.
     *
     * @param id the id of the entity
     */
    void delete(Long id);

    /**
     * Search for the sistemaComCanales corresponding to the query.
     *
     * @param query the query of the search
     * 
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<SistemaComCanalesDTO> search(String query, Pageable pageable);
}
