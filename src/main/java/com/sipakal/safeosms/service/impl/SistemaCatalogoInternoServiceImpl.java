package com.sipakal.safeosms.service.impl;

import com.sipakal.safeosms.service.SistemaCatalogoInternoService;
import com.sipakal.safeosms.domain.SistemaCatalogoInterno;
import com.sipakal.safeosms.repository.SistemaCatalogoInternoRepository;
import com.sipakal.safeosms.repository.search.SistemaCatalogoInternoSearchRepository;
import com.sipakal.safeosms.service.dto.SistemaCatalogoInternoDTO;
import com.sipakal.safeosms.service.mapper.SistemaCatalogoInternoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing SistemaCatalogoInterno.
 */
@Service
@Transactional
public class SistemaCatalogoInternoServiceImpl implements SistemaCatalogoInternoService {

    private final Logger log = LoggerFactory.getLogger(SistemaCatalogoInternoServiceImpl.class);

    private final SistemaCatalogoInternoRepository sistemaCatalogoInternoRepository;

    private final SistemaCatalogoInternoMapper sistemaCatalogoInternoMapper;

    private final SistemaCatalogoInternoSearchRepository sistemaCatalogoInternoSearchRepository;

    public SistemaCatalogoInternoServiceImpl(SistemaCatalogoInternoRepository sistemaCatalogoInternoRepository, SistemaCatalogoInternoMapper sistemaCatalogoInternoMapper, SistemaCatalogoInternoSearchRepository sistemaCatalogoInternoSearchRepository) {
        this.sistemaCatalogoInternoRepository = sistemaCatalogoInternoRepository;
        this.sistemaCatalogoInternoMapper = sistemaCatalogoInternoMapper;
        this.sistemaCatalogoInternoSearchRepository = sistemaCatalogoInternoSearchRepository;
    }

    /**
     * Save a sistemaCatalogoInterno.
     *
     * @param sistemaCatalogoInternoDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public SistemaCatalogoInternoDTO save(SistemaCatalogoInternoDTO sistemaCatalogoInternoDTO) {
        log.debug("Request to save SistemaCatalogoInterno : {}", sistemaCatalogoInternoDTO);
        SistemaCatalogoInterno sistemaCatalogoInterno = sistemaCatalogoInternoMapper.toEntity(sistemaCatalogoInternoDTO);
        sistemaCatalogoInterno = sistemaCatalogoInternoRepository.save(sistemaCatalogoInterno);
        SistemaCatalogoInternoDTO result = sistemaCatalogoInternoMapper.toDto(sistemaCatalogoInterno);
        sistemaCatalogoInternoSearchRepository.save(sistemaCatalogoInterno);
        return result;
    }

    /**
     * Get all the sistemaCatalogoInternos.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<SistemaCatalogoInternoDTO> findAll(Pageable pageable) {
        log.debug("Request to get all SistemaCatalogoInternos");
        return sistemaCatalogoInternoRepository.findAll(pageable)
            .map(sistemaCatalogoInternoMapper::toDto);
    }

    /**
     * Get one sistemaCatalogoInterno by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public SistemaCatalogoInternoDTO findOne(Long id) {
        log.debug("Request to get SistemaCatalogoInterno : {}", id);
        SistemaCatalogoInterno sistemaCatalogoInterno = sistemaCatalogoInternoRepository.findOne(id);
        return sistemaCatalogoInternoMapper.toDto(sistemaCatalogoInterno);
    }

    /**
     * Delete the sistemaCatalogoInterno by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete SistemaCatalogoInterno : {}", id);
        sistemaCatalogoInternoRepository.delete(id);
        sistemaCatalogoInternoSearchRepository.delete(id);
    }

    /**
     * Search for the sistemaCatalogoInterno corresponding to the query.
     *
     * @param query the query of the search
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<SistemaCatalogoInternoDTO> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of SistemaCatalogoInternos for query {}", query);
        Page<SistemaCatalogoInterno> result = sistemaCatalogoInternoSearchRepository.search(queryStringQuery(query), pageable);
        return result.map(sistemaCatalogoInternoMapper::toDto);
    }
}
