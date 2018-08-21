package com.sipakal.safeosms.service;

import com.sipakal.safeosms.service.dto.SistemaConfiguracionDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing SistemaConfiguracion.
 */
public interface SistemaConfiguracionService {

    /**
     * Save a sistemaConfiguracion.
     *
     * @param sistemaConfiguracionDTO the entity to save
     * @return the persisted entity
     */
    SistemaConfiguracionDTO save(SistemaConfiguracionDTO sistemaConfiguracionDTO);

    /**
     * Get all the sistemaConfiguracions.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<SistemaConfiguracionDTO> findAll(Pageable pageable);

    /**
     * Get the "id" sistemaConfiguracion.
     *
     * @param id the id of the entity
     * @return the entity
     */
    SistemaConfiguracionDTO findOne(Long id);

    /**
     * Delete the "id" sistemaConfiguracion.
     *
     * @param id the id of the entity
     */
    void delete(Long id);

    /**
     * Search for the sistemaConfiguracion corresponding to the query.
     *
     * @param query the query of the search
     * 
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<SistemaConfiguracionDTO> search(String query, Pageable pageable);
}
