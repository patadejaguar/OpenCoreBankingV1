package com.sipakal.safeosms.service.impl;

import com.sipakal.safeosms.service.SistemaNivelRiesgoService;
import com.sipakal.safeosms.domain.SistemaNivelRiesgo;
import com.sipakal.safeosms.repository.SistemaNivelRiesgoRepository;
import com.sipakal.safeosms.repository.search.SistemaNivelRiesgoSearchRepository;
import com.sipakal.safeosms.service.dto.SistemaNivelRiesgoDTO;
import com.sipakal.safeosms.service.mapper.SistemaNivelRiesgoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing SistemaNivelRiesgo.
 */
@Service
@Transactional
public class SistemaNivelRiesgoServiceImpl implements SistemaNivelRiesgoService {

    private final Logger log = LoggerFactory.getLogger(SistemaNivelRiesgoServiceImpl.class);

    private final SistemaNivelRiesgoRepository sistemaNivelRiesgoRepository;

    private final SistemaNivelRiesgoMapper sistemaNivelRiesgoMapper;

    private final SistemaNivelRiesgoSearchRepository sistemaNivelRiesgoSearchRepository;

    public SistemaNivelRiesgoServiceImpl(SistemaNivelRiesgoRepository sistemaNivelRiesgoRepository, SistemaNivelRiesgoMapper sistemaNivelRiesgoMapper, SistemaNivelRiesgoSearchRepository sistemaNivelRiesgoSearchRepository) {
        this.sistemaNivelRiesgoRepository = sistemaNivelRiesgoRepository;
        this.sistemaNivelRiesgoMapper = sistemaNivelRiesgoMapper;
        this.sistemaNivelRiesgoSearchRepository = sistemaNivelRiesgoSearchRepository;
    }

    /**
     * Save a sistemaNivelRiesgo.
     *
     * @param sistemaNivelRiesgoDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public SistemaNivelRiesgoDTO save(SistemaNivelRiesgoDTO sistemaNivelRiesgoDTO) {
        log.debug("Request to save SistemaNivelRiesgo : {}", sistemaNivelRiesgoDTO);
        SistemaNivelRiesgo sistemaNivelRiesgo = sistemaNivelRiesgoMapper.toEntity(sistemaNivelRiesgoDTO);
        sistemaNivelRiesgo = sistemaNivelRiesgoRepository.save(sistemaNivelRiesgo);
        SistemaNivelRiesgoDTO result = sistemaNivelRiesgoMapper.toDto(sistemaNivelRiesgo);
        sistemaNivelRiesgoSearchRepository.save(sistemaNivelRiesgo);
        return result;
    }

    /**
     * Get all the sistemaNivelRiesgos.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<SistemaNivelRiesgoDTO> findAll(Pageable pageable) {
        log.debug("Request to get all SistemaNivelRiesgos");
        return sistemaNivelRiesgoRepository.findAll(pageable)
            .map(sistemaNivelRiesgoMapper::toDto);
    }

    /**
     * Get one sistemaNivelRiesgo by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public SistemaNivelRiesgoDTO findOne(Long id) {
        log.debug("Request to get SistemaNivelRiesgo : {}", id);
        SistemaNivelRiesgo sistemaNivelRiesgo = sistemaNivelRiesgoRepository.findOne(id);
        return sistemaNivelRiesgoMapper.toDto(sistemaNivelRiesgo);
    }

    /**
     * Delete the sistemaNivelRiesgo by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete SistemaNivelRiesgo : {}", id);
        sistemaNivelRiesgoRepository.delete(id);
        sistemaNivelRiesgoSearchRepository.delete(id);
    }

    /**
     * Search for the sistemaNivelRiesgo corresponding to the query.
     *
     * @param query the query of the search
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<SistemaNivelRiesgoDTO> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of SistemaNivelRiesgos for query {}", query);
        Page<SistemaNivelRiesgo> result = sistemaNivelRiesgoSearchRepository.search(queryStringQuery(query), pageable);
        return result.map(sistemaNivelRiesgoMapper::toDto);
    }
}
