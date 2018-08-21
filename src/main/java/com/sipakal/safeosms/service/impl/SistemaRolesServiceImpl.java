package com.sipakal.safeosms.service.impl;

import com.sipakal.safeosms.service.SistemaRolesService;
import com.sipakal.safeosms.domain.SistemaRoles;
import com.sipakal.safeosms.repository.SistemaRolesRepository;
import com.sipakal.safeosms.repository.search.SistemaRolesSearchRepository;
import com.sipakal.safeosms.service.dto.SistemaRolesDTO;
import com.sipakal.safeosms.service.mapper.SistemaRolesMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing SistemaRoles.
 */
@Service
@Transactional
public class SistemaRolesServiceImpl implements SistemaRolesService {

    private final Logger log = LoggerFactory.getLogger(SistemaRolesServiceImpl.class);

    private final SistemaRolesRepository sistemaRolesRepository;

    private final SistemaRolesMapper sistemaRolesMapper;

    private final SistemaRolesSearchRepository sistemaRolesSearchRepository;

    public SistemaRolesServiceImpl(SistemaRolesRepository sistemaRolesRepository, SistemaRolesMapper sistemaRolesMapper, SistemaRolesSearchRepository sistemaRolesSearchRepository) {
        this.sistemaRolesRepository = sistemaRolesRepository;
        this.sistemaRolesMapper = sistemaRolesMapper;
        this.sistemaRolesSearchRepository = sistemaRolesSearchRepository;
    }

    /**
     * Save a sistemaRoles.
     *
     * @param sistemaRolesDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public SistemaRolesDTO save(SistemaRolesDTO sistemaRolesDTO) {
        log.debug("Request to save SistemaRoles : {}", sistemaRolesDTO);
        SistemaRoles sistemaRoles = sistemaRolesMapper.toEntity(sistemaRolesDTO);
        sistemaRoles = sistemaRolesRepository.save(sistemaRoles);
        SistemaRolesDTO result = sistemaRolesMapper.toDto(sistemaRoles);
        sistemaRolesSearchRepository.save(sistemaRoles);
        return result;
    }

    /**
     * Get all the sistemaRoles.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<SistemaRolesDTO> findAll(Pageable pageable) {
        log.debug("Request to get all SistemaRoles");
        return sistemaRolesRepository.findAll(pageable)
            .map(sistemaRolesMapper::toDto);
    }

    /**
     * Get one sistemaRoles by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public SistemaRolesDTO findOne(Long id) {
        log.debug("Request to get SistemaRoles : {}", id);
        SistemaRoles sistemaRoles = sistemaRolesRepository.findOne(id);
        return sistemaRolesMapper.toDto(sistemaRoles);
    }

    /**
     * Delete the sistemaRoles by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete SistemaRoles : {}", id);
        sistemaRolesRepository.delete(id);
        sistemaRolesSearchRepository.delete(id);
    }

    /**
     * Search for the sistemaRoles corresponding to the query.
     *
     * @param query the query of the search
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<SistemaRolesDTO> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of SistemaRoles for query {}", query);
        Page<SistemaRoles> result = sistemaRolesSearchRepository.search(queryStringQuery(query), pageable);
        return result.map(sistemaRolesMapper::toDto);
    }
}
