package com.sipakal.safeosms.service.impl;

import com.sipakal.safeosms.service.SistemaProductosTiposService;
import com.sipakal.safeosms.domain.SistemaProductosTipos;
import com.sipakal.safeosms.repository.SistemaProductosTiposRepository;
import com.sipakal.safeosms.repository.search.SistemaProductosTiposSearchRepository;
import com.sipakal.safeosms.service.dto.SistemaProductosTiposDTO;
import com.sipakal.safeosms.service.mapper.SistemaProductosTiposMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing SistemaProductosTipos.
 */
@Service
@Transactional
public class SistemaProductosTiposServiceImpl implements SistemaProductosTiposService {

    private final Logger log = LoggerFactory.getLogger(SistemaProductosTiposServiceImpl.class);

    private final SistemaProductosTiposRepository sistemaProductosTiposRepository;

    private final SistemaProductosTiposMapper sistemaProductosTiposMapper;

    private final SistemaProductosTiposSearchRepository sistemaProductosTiposSearchRepository;

    public SistemaProductosTiposServiceImpl(SistemaProductosTiposRepository sistemaProductosTiposRepository, SistemaProductosTiposMapper sistemaProductosTiposMapper, SistemaProductosTiposSearchRepository sistemaProductosTiposSearchRepository) {
        this.sistemaProductosTiposRepository = sistemaProductosTiposRepository;
        this.sistemaProductosTiposMapper = sistemaProductosTiposMapper;
        this.sistemaProductosTiposSearchRepository = sistemaProductosTiposSearchRepository;
    }

    /**
     * Save a sistemaProductosTipos.
     *
     * @param sistemaProductosTiposDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public SistemaProductosTiposDTO save(SistemaProductosTiposDTO sistemaProductosTiposDTO) {
        log.debug("Request to save SistemaProductosTipos : {}", sistemaProductosTiposDTO);
        SistemaProductosTipos sistemaProductosTipos = sistemaProductosTiposMapper.toEntity(sistemaProductosTiposDTO);
        sistemaProductosTipos = sistemaProductosTiposRepository.save(sistemaProductosTipos);
        SistemaProductosTiposDTO result = sistemaProductosTiposMapper.toDto(sistemaProductosTipos);
        sistemaProductosTiposSearchRepository.save(sistemaProductosTipos);
        return result;
    }

    /**
     * Get all the sistemaProductosTipos.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<SistemaProductosTiposDTO> findAll(Pageable pageable) {
        log.debug("Request to get all SistemaProductosTipos");
        return sistemaProductosTiposRepository.findAll(pageable)
            .map(sistemaProductosTiposMapper::toDto);
    }

    /**
     * Get one sistemaProductosTipos by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public SistemaProductosTiposDTO findOne(Long id) {
        log.debug("Request to get SistemaProductosTipos : {}", id);
        SistemaProductosTipos sistemaProductosTipos = sistemaProductosTiposRepository.findOne(id);
        return sistemaProductosTiposMapper.toDto(sistemaProductosTipos);
    }

    /**
     * Delete the sistemaProductosTipos by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete SistemaProductosTipos : {}", id);
        sistemaProductosTiposRepository.delete(id);
        sistemaProductosTiposSearchRepository.delete(id);
    }

    /**
     * Search for the sistemaProductosTipos corresponding to the query.
     *
     * @param query the query of the search
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<SistemaProductosTiposDTO> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of SistemaProductosTipos for query {}", query);
        Page<SistemaProductosTipos> result = sistemaProductosTiposSearchRepository.search(queryStringQuery(query), pageable);
        return result.map(sistemaProductosTiposMapper::toDto);
    }
}
