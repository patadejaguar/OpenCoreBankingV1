package com.sipakal.safeosms.service;

import com.sipakal.safeosms.service.dto.SistemaMsjLargoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing SistemaMsjLargo.
 */
public interface SistemaMsjLargoService {

    /**
     * Save a sistemaMsjLargo.
     *
     * @param sistemaMsjLargoDTO the entity to save
     * @return the persisted entity
     */
    SistemaMsjLargoDTO save(SistemaMsjLargoDTO sistemaMsjLargoDTO);

    /**
     * Get all the sistemaMsjLargos.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<SistemaMsjLargoDTO> findAll(Pageable pageable);

    /**
     * Get the "id" sistemaMsjLargo.
     *
     * @param id the id of the entity
     * @return the entity
     */
    SistemaMsjLargoDTO findOne(Long id);

    /**
     * Delete the "id" sistemaMsjLargo.
     *
     * @param id the id of the entity
     */
    void delete(Long id);

    /**
     * Search for the sistemaMsjLargo corresponding to the query.
     *
     * @param query the query of the search
     * 
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<SistemaMsjLargoDTO> search(String query, Pageable pageable);
}
