package com.sipakal.safeosms.service.impl;

import com.sipakal.safeosms.service.SistemaConfiguracionService;
import com.sipakal.safeosms.domain.SistemaConfiguracion;
import com.sipakal.safeosms.repository.SistemaConfiguracionRepository;
import com.sipakal.safeosms.repository.search.SistemaConfiguracionSearchRepository;
import com.sipakal.safeosms.service.dto.SistemaConfiguracionDTO;
import com.sipakal.safeosms.service.mapper.SistemaConfiguracionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing SistemaConfiguracion.
 */
@Service
@Transactional
public class SistemaConfiguracionServiceImpl implements SistemaConfiguracionService {

    private final Logger log = LoggerFactory.getLogger(SistemaConfiguracionServiceImpl.class);

    private final SistemaConfiguracionRepository sistemaConfiguracionRepository;

    private final SistemaConfiguracionMapper sistemaConfiguracionMapper;

    private final SistemaConfiguracionSearchRepository sistemaConfiguracionSearchRepository;

    public SistemaConfiguracionServiceImpl(SistemaConfiguracionRepository sistemaConfiguracionRepository, SistemaConfiguracionMapper sistemaConfiguracionMapper, SistemaConfiguracionSearchRepository sistemaConfiguracionSearchRepository) {
        this.sistemaConfiguracionRepository = sistemaConfiguracionRepository;
        this.sistemaConfiguracionMapper = sistemaConfiguracionMapper;
        this.sistemaConfiguracionSearchRepository = sistemaConfiguracionSearchRepository;
    }

    /**
     * Save a sistemaConfiguracion.
     *
     * @param sistemaConfiguracionDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public SistemaConfiguracionDTO save(SistemaConfiguracionDTO sistemaConfiguracionDTO) {
        log.debug("Request to save SistemaConfiguracion : {}", sistemaConfiguracionDTO);
        SistemaConfiguracion sistemaConfiguracion = sistemaConfiguracionMapper.toEntity(sistemaConfiguracionDTO);
        sistemaConfiguracion = sistemaConfiguracionRepository.save(sistemaConfiguracion);
        SistemaConfiguracionDTO result = sistemaConfiguracionMapper.toDto(sistemaConfiguracion);
        sistemaConfiguracionSearchRepository.save(sistemaConfiguracion);
        return result;
    }

    /**
     * Get all the sistemaConfiguracions.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<SistemaConfiguracionDTO> findAll(Pageable pageable) {
        log.debug("Request to get all SistemaConfiguracions");
        return sistemaConfiguracionRepository.findAll(pageable)
            .map(sistemaConfiguracionMapper::toDto);
    }

    /**
     * Get one sistemaConfiguracion by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public SistemaConfiguracionDTO findOne(Long id) {
        log.debug("Request to get SistemaConfiguracion : {}", id);
        SistemaConfiguracion sistemaConfiguracion = sistemaConfiguracionRepository.findOne(id);
        return sistemaConfiguracionMapper.toDto(sistemaConfiguracion);
    }

    /**
     * Delete the sistemaConfiguracion by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete SistemaConfiguracion : {}", id);
        sistemaConfiguracionRepository.delete(id);
        sistemaConfiguracionSearchRepository.delete(id);
    }

    /**
     * Search for the sistemaConfiguracion corresponding to the query.
     *
     * @param query the query of the search
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<SistemaConfiguracionDTO> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of SistemaConfiguracions for query {}", query);
        Page<SistemaConfiguracion> result = sistemaConfiguracionSearchRepository.search(queryStringQuery(query), pageable);
        return result.map(sistemaConfiguracionMapper::toDto);
    }
}
