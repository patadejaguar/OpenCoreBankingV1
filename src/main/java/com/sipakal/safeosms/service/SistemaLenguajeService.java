package com.sipakal.safeosms.service;

import com.sipakal.safeosms.service.dto.SistemaLenguajeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing SistemaLenguaje.
 */
public interface SistemaLenguajeService {

    /**
     * Save a sistemaLenguaje.
     *
     * @param sistemaLenguajeDTO the entity to save
     * @return the persisted entity
     */
    SistemaLenguajeDTO save(SistemaLenguajeDTO sistemaLenguajeDTO);

    /**
     * Get all the sistemaLenguajes.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<SistemaLenguajeDTO> findAll(Pageable pageable);

    /**
     * Get the "id" sistemaLenguaje.
     *
     * @param id the id of the entity
     * @return the entity
     */
    SistemaLenguajeDTO findOne(Long id);

    /**
     * Delete the "id" sistemaLenguaje.
     *
     * @param id the id of the entity
     */
    void delete(Long id);

    /**
     * Search for the sistemaLenguaje corresponding to the query.
     *
     * @param query the query of the search
     * 
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<SistemaLenguajeDTO> search(String query, Pageable pageable);
}
