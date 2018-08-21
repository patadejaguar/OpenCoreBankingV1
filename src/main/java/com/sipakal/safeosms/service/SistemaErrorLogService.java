package com.sipakal.safeosms.service;

import com.sipakal.safeosms.service.dto.SistemaErrorLogDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing SistemaErrorLog.
 */
public interface SistemaErrorLogService {

    /**
     * Save a sistemaErrorLog.
     *
     * @param sistemaErrorLogDTO the entity to save
     * @return the persisted entity
     */
    SistemaErrorLogDTO save(SistemaErrorLogDTO sistemaErrorLogDTO);

    /**
     * Get all the sistemaErrorLogs.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<SistemaErrorLogDTO> findAll(Pageable pageable);

    /**
     * Get the "id" sistemaErrorLog.
     *
     * @param id the id of the entity
     * @return the entity
     */
    SistemaErrorLogDTO findOne(Long id);

    /**
     * Delete the "id" sistemaErrorLog.
     *
     * @param id the id of the entity
     */
    void delete(Long id);

    /**
     * Search for the sistemaErrorLog corresponding to the query.
     *
     * @param query the query of the search
     * 
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<SistemaErrorLogDTO> search(String query, Pageable pageable);
}
