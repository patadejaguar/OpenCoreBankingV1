package com.sipakal.safeosms.service;

import com.sipakal.safeosms.service.dto.SistemaCatalogoInternoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing SistemaCatalogoInterno.
 */
public interface SistemaCatalogoInternoService {

    /**
     * Save a sistemaCatalogoInterno.
     *
     * @param sistemaCatalogoInternoDTO the entity to save
     * @return the persisted entity
     */
    SistemaCatalogoInternoDTO save(SistemaCatalogoInternoDTO sistemaCatalogoInternoDTO);

    /**
     * Get all the sistemaCatalogoInternos.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<SistemaCatalogoInternoDTO> findAll(Pageable pageable);

    /**
     * Get the "id" sistemaCatalogoInterno.
     *
     * @param id the id of the entity
     * @return the entity
     */
    SistemaCatalogoInternoDTO findOne(Long id);

    /**
     * Delete the "id" sistemaCatalogoInterno.
     *
     * @param id the id of the entity
     */
    void delete(Long id);

    /**
     * Search for the sistemaCatalogoInterno corresponding to the query.
     *
     * @param query the query of the search
     * 
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<SistemaCatalogoInternoDTO> search(String query, Pageable pageable);
}
