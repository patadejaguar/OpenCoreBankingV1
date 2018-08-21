package com.sipakal.safeosms.service.impl;

import com.sipakal.safeosms.service.SistemaComCanalesService;
import com.sipakal.safeosms.domain.SistemaComCanales;
import com.sipakal.safeosms.repository.SistemaComCanalesRepository;
import com.sipakal.safeosms.repository.search.SistemaComCanalesSearchRepository;
import com.sipakal.safeosms.service.dto.SistemaComCanalesDTO;
import com.sipakal.safeosms.service.mapper.SistemaComCanalesMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing SistemaComCanales.
 */
@Service
@Transactional
public class SistemaComCanalesServiceImpl implements SistemaComCanalesService {

    private final Logger log = LoggerFactory.getLogger(SistemaComCanalesServiceImpl.class);

    private final SistemaComCanalesRepository sistemaComCanalesRepository;

    private final SistemaComCanalesMapper sistemaComCanalesMapper;

    private final SistemaComCanalesSearchRepository sistemaComCanalesSearchRepository;

    public SistemaComCanalesServiceImpl(SistemaComCanalesRepository sistemaComCanalesRepository, SistemaComCanalesMapper sistemaComCanalesMapper, SistemaComCanalesSearchRepository sistemaComCanalesSearchRepository) {
        this.sistemaComCanalesRepository = sistemaComCanalesRepository;
        this.sistemaComCanalesMapper = sistemaComCanalesMapper;
        this.sistemaComCanalesSearchRepository = sistemaComCanalesSearchRepository;
    }

    /**
     * Save a sistemaComCanales.
     *
     * @param sistemaComCanalesDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public SistemaComCanalesDTO save(SistemaComCanalesDTO sistemaComCanalesDTO) {
        log.debug("Request to save SistemaComCanales : {}", sistemaComCanalesDTO);
        SistemaComCanales sistemaComCanales = sistemaComCanalesMapper.toEntity(sistemaComCanalesDTO);
        sistemaComCanales = sistemaComCanalesRepository.save(sistemaComCanales);
        SistemaComCanalesDTO result = sistemaComCanalesMapper.toDto(sistemaComCanales);
        sistemaComCanalesSearchRepository.save(sistemaComCanales);
        return result;
    }

    /**
     * Get all the sistemaComCanales.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<SistemaComCanalesDTO> findAll(Pageable pageable) {
        log.debug("Request to get all SistemaComCanales");
        return sistemaComCanalesRepository.findAll(pageable)
            .map(sistemaComCanalesMapper::toDto);
    }

    /**
     * Get one sistemaComCanales by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public SistemaComCanalesDTO findOne(Long id) {
        log.debug("Request to get SistemaComCanales : {}", id);
        SistemaComCanales sistemaComCanales = sistemaComCanalesRepository.findOne(id);
        return sistemaComCanalesMapper.toDto(sistemaComCanales);
    }

    /**
     * Delete the sistemaComCanales by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete SistemaComCanales : {}", id);
        sistemaComCanalesRepository.delete(id);
        sistemaComCanalesSearchRepository.delete(id);
    }

    /**
     * Search for the sistemaComCanales corresponding to the query.
     *
     * @param query the query of the search
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<SistemaComCanalesDTO> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of SistemaComCanales for query {}", query);
        Page<SistemaComCanales> result = sistemaComCanalesSearchRepository.search(queryStringQuery(query), pageable);
        return result.map(sistemaComCanalesMapper::toDto);
    }
}
