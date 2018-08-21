package com.sipakal.safeosms.service.impl;

import com.sipakal.safeosms.service.SistemaLenguajeService;
import com.sipakal.safeosms.domain.SistemaLenguaje;
import com.sipakal.safeosms.repository.SistemaLenguajeRepository;
import com.sipakal.safeosms.repository.search.SistemaLenguajeSearchRepository;
import com.sipakal.safeosms.service.dto.SistemaLenguajeDTO;
import com.sipakal.safeosms.service.mapper.SistemaLenguajeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing SistemaLenguaje.
 */
@Service
@Transactional
public class SistemaLenguajeServiceImpl implements SistemaLenguajeService {

    private final Logger log = LoggerFactory.getLogger(SistemaLenguajeServiceImpl.class);

    private final SistemaLenguajeRepository sistemaLenguajeRepository;

    private final SistemaLenguajeMapper sistemaLenguajeMapper;

    private final SistemaLenguajeSearchRepository sistemaLenguajeSearchRepository;

    public SistemaLenguajeServiceImpl(SistemaLenguajeRepository sistemaLenguajeRepository, SistemaLenguajeMapper sistemaLenguajeMapper, SistemaLenguajeSearchRepository sistemaLenguajeSearchRepository) {
        this.sistemaLenguajeRepository = sistemaLenguajeRepository;
        this.sistemaLenguajeMapper = sistemaLenguajeMapper;
        this.sistemaLenguajeSearchRepository = sistemaLenguajeSearchRepository;
    }

    /**
     * Save a sistemaLenguaje.
     *
     * @param sistemaLenguajeDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public SistemaLenguajeDTO save(SistemaLenguajeDTO sistemaLenguajeDTO) {
        log.debug("Request to save SistemaLenguaje : {}", sistemaLenguajeDTO);
        SistemaLenguaje sistemaLenguaje = sistemaLenguajeMapper.toEntity(sistemaLenguajeDTO);
        sistemaLenguaje = sistemaLenguajeRepository.save(sistemaLenguaje);
        SistemaLenguajeDTO result = sistemaLenguajeMapper.toDto(sistemaLenguaje);
        sistemaLenguajeSearchRepository.save(sistemaLenguaje);
        return result;
    }

    /**
     * Get all the sistemaLenguajes.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<SistemaLenguajeDTO> findAll(Pageable pageable) {
        log.debug("Request to get all SistemaLenguajes");
        return sistemaLenguajeRepository.findAll(pageable)
            .map(sistemaLenguajeMapper::toDto);
    }

    /**
     * Get one sistemaLenguaje by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public SistemaLenguajeDTO findOne(Long id) {
        log.debug("Request to get SistemaLenguaje : {}", id);
        SistemaLenguaje sistemaLenguaje = sistemaLenguajeRepository.findOne(id);
        return sistemaLenguajeMapper.toDto(sistemaLenguaje);
    }

    /**
     * Delete the sistemaLenguaje by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete SistemaLenguaje : {}", id);
        sistemaLenguajeRepository.delete(id);
        sistemaLenguajeSearchRepository.delete(id);
    }

    /**
     * Search for the sistemaLenguaje corresponding to the query.
     *
     * @param query the query of the search
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<SistemaLenguajeDTO> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of SistemaLenguajes for query {}", query);
        Page<SistemaLenguaje> result = sistemaLenguajeSearchRepository.search(queryStringQuery(query), pageable);
        return result.map(sistemaLenguajeMapper::toDto);
    }
}
