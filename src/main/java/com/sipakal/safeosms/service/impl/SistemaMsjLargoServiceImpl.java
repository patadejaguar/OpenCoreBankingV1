package com.sipakal.safeosms.service.impl;

import com.sipakal.safeosms.service.SistemaMsjLargoService;
import com.sipakal.safeosms.domain.SistemaMsjLargo;
import com.sipakal.safeosms.repository.SistemaMsjLargoRepository;
import com.sipakal.safeosms.repository.search.SistemaMsjLargoSearchRepository;
import com.sipakal.safeosms.service.dto.SistemaMsjLargoDTO;
import com.sipakal.safeosms.service.mapper.SistemaMsjLargoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing SistemaMsjLargo.
 */
@Service
@Transactional
public class SistemaMsjLargoServiceImpl implements SistemaMsjLargoService {

    private final Logger log = LoggerFactory.getLogger(SistemaMsjLargoServiceImpl.class);

    private final SistemaMsjLargoRepository sistemaMsjLargoRepository;

    private final SistemaMsjLargoMapper sistemaMsjLargoMapper;

    private final SistemaMsjLargoSearchRepository sistemaMsjLargoSearchRepository;

    public SistemaMsjLargoServiceImpl(SistemaMsjLargoRepository sistemaMsjLargoRepository, SistemaMsjLargoMapper sistemaMsjLargoMapper, SistemaMsjLargoSearchRepository sistemaMsjLargoSearchRepository) {
        this.sistemaMsjLargoRepository = sistemaMsjLargoRepository;
        this.sistemaMsjLargoMapper = sistemaMsjLargoMapper;
        this.sistemaMsjLargoSearchRepository = sistemaMsjLargoSearchRepository;
    }

    /**
     * Save a sistemaMsjLargo.
     *
     * @param sistemaMsjLargoDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public SistemaMsjLargoDTO save(SistemaMsjLargoDTO sistemaMsjLargoDTO) {
        log.debug("Request to save SistemaMsjLargo : {}", sistemaMsjLargoDTO);
        SistemaMsjLargo sistemaMsjLargo = sistemaMsjLargoMapper.toEntity(sistemaMsjLargoDTO);
        sistemaMsjLargo = sistemaMsjLargoRepository.save(sistemaMsjLargo);
        SistemaMsjLargoDTO result = sistemaMsjLargoMapper.toDto(sistemaMsjLargo);
        sistemaMsjLargoSearchRepository.save(sistemaMsjLargo);
        return result;
    }

    /**
     * Get all the sistemaMsjLargos.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<SistemaMsjLargoDTO> findAll(Pageable pageable) {
        log.debug("Request to get all SistemaMsjLargos");
        return sistemaMsjLargoRepository.findAll(pageable)
            .map(sistemaMsjLargoMapper::toDto);
    }

    /**
     * Get one sistemaMsjLargo by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public SistemaMsjLargoDTO findOne(Long id) {
        log.debug("Request to get SistemaMsjLargo : {}", id);
        SistemaMsjLargo sistemaMsjLargo = sistemaMsjLargoRepository.findOne(id);
        return sistemaMsjLargoMapper.toDto(sistemaMsjLargo);
    }

    /**
     * Delete the sistemaMsjLargo by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete SistemaMsjLargo : {}", id);
        sistemaMsjLargoRepository.delete(id);
        sistemaMsjLargoSearchRepository.delete(id);
    }

    /**
     * Search for the sistemaMsjLargo corresponding to the query.
     *
     * @param query the query of the search
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<SistemaMsjLargoDTO> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of SistemaMsjLargos for query {}", query);
        Page<SistemaMsjLargo> result = sistemaMsjLargoSearchRepository.search(queryStringQuery(query), pageable);
        return result.map(sistemaMsjLargoMapper::toDto);
    }
}
