package com.sipakal.safeosms.service.impl;

import com.sipakal.safeosms.service.SistemaErrorTiposService;
import com.sipakal.safeosms.domain.SistemaErrorTipos;
import com.sipakal.safeosms.repository.SistemaErrorTiposRepository;
import com.sipakal.safeosms.repository.search.SistemaErrorTiposSearchRepository;
import com.sipakal.safeosms.service.dto.SistemaErrorTiposDTO;
import com.sipakal.safeosms.service.mapper.SistemaErrorTiposMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing SistemaErrorTipos.
 */
@Service
@Transactional
public class SistemaErrorTiposServiceImpl implements SistemaErrorTiposService {

    private final Logger log = LoggerFactory.getLogger(SistemaErrorTiposServiceImpl.class);

    private final SistemaErrorTiposRepository sistemaErrorTiposRepository;

    private final SistemaErrorTiposMapper sistemaErrorTiposMapper;

    private final SistemaErrorTiposSearchRepository sistemaErrorTiposSearchRepository;

    public SistemaErrorTiposServiceImpl(SistemaErrorTiposRepository sistemaErrorTiposRepository, SistemaErrorTiposMapper sistemaErrorTiposMapper, SistemaErrorTiposSearchRepository sistemaErrorTiposSearchRepository) {
        this.sistemaErrorTiposRepository = sistemaErrorTiposRepository;
        this.sistemaErrorTiposMapper = sistemaErrorTiposMapper;
        this.sistemaErrorTiposSearchRepository = sistemaErrorTiposSearchRepository;
    }

    /**
     * Save a sistemaErrorTipos.
     *
     * @param sistemaErrorTiposDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public SistemaErrorTiposDTO save(SistemaErrorTiposDTO sistemaErrorTiposDTO) {
        log.debug("Request to save SistemaErrorTipos : {}", sistemaErrorTiposDTO);
        SistemaErrorTipos sistemaErrorTipos = sistemaErrorTiposMapper.toEntity(sistemaErrorTiposDTO);
        sistemaErrorTipos = sistemaErrorTiposRepository.save(sistemaErrorTipos);
        SistemaErrorTiposDTO result = sistemaErrorTiposMapper.toDto(sistemaErrorTipos);
        sistemaErrorTiposSearchRepository.save(sistemaErrorTipos);
        return result;
    }

    /**
     * Get all the sistemaErrorTipos.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<SistemaErrorTiposDTO> findAll(Pageable pageable) {
        log.debug("Request to get all SistemaErrorTipos");
        return sistemaErrorTiposRepository.findAll(pageable)
            .map(sistemaErrorTiposMapper::toDto);
    }

    /**
     * Get one sistemaErrorTipos by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public SistemaErrorTiposDTO findOne(Long id) {
        log.debug("Request to get SistemaErrorTipos : {}", id);
        SistemaErrorTipos sistemaErrorTipos = sistemaErrorTiposRepository.findOne(id);
        return sistemaErrorTiposMapper.toDto(sistemaErrorTipos);
    }

    /**
     * Delete the sistemaErrorTipos by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete SistemaErrorTipos : {}", id);
        sistemaErrorTiposRepository.delete(id);
        sistemaErrorTiposSearchRepository.delete(id);
    }

    /**
     * Search for the sistemaErrorTipos corresponding to the query.
     *
     * @param query the query of the search
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<SistemaErrorTiposDTO> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of SistemaErrorTipos for query {}", query);
        Page<SistemaErrorTipos> result = sistemaErrorTiposSearchRepository.search(queryStringQuery(query), pageable);
        return result.map(sistemaErrorTiposMapper::toDto);
    }
}
