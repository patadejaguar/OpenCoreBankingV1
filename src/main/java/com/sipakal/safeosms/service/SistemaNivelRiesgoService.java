package com.sipakal.safeosms.service;

import com.sipakal.safeosms.service.dto.SistemaNivelRiesgoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing SistemaNivelRiesgo.
 */
public interface SistemaNivelRiesgoService {

    /**
     * Save a sistemaNivelRiesgo.
     *
     * @param sistemaNivelRiesgoDTO the entity to save
     * @return the persisted entity
     */
    SistemaNivelRiesgoDTO save(SistemaNivelRiesgoDTO sistemaNivelRiesgoDTO);

    /**
     * Get all the sistemaNivelRiesgos.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<SistemaNivelRiesgoDTO> findAll(Pageable pageable);

    /**
     * Get the "id" sistemaNivelRiesgo.
     *
     * @param id the id of the entity
     * @return the entity
     */
    SistemaNivelRiesgoDTO findOne(Long id);

    /**
     * Delete the "id" sistemaNivelRiesgo.
     *
     * @param id the id of the entity
     */
    void delete(Long id);

    /**
     * Search for the sistemaNivelRiesgo corresponding to the query.
     *
     * @param query the query of the search
     * 
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<SistemaNivelRiesgoDTO> search(String query, Pageable pageable);
}
