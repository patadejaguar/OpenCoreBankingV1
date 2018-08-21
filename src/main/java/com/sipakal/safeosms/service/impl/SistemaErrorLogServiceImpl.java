package com.sipakal.safeosms.service.impl;

import com.sipakal.safeosms.service.SistemaErrorLogService;
import com.sipakal.safeosms.domain.SistemaErrorLog;
import com.sipakal.safeosms.repository.SistemaErrorLogRepository;
import com.sipakal.safeosms.repository.search.SistemaErrorLogSearchRepository;
import com.sipakal.safeosms.service.dto.SistemaErrorLogDTO;
import com.sipakal.safeosms.service.mapper.SistemaErrorLogMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing SistemaErrorLog.
 */
@Service
@Transactional
public class SistemaErrorLogServiceImpl implements SistemaErrorLogService {

    private final Logger log = LoggerFactory.getLogger(SistemaErrorLogServiceImpl.class);

    private final SistemaErrorLogRepository sistemaErrorLogRepository;

    private final SistemaErrorLogMapper sistemaErrorLogMapper;

    private final SistemaErrorLogSearchRepository sistemaErrorLogSearchRepository;

    public SistemaErrorLogServiceImpl(SistemaErrorLogRepository sistemaErrorLogRepository, SistemaErrorLogMapper sistemaErrorLogMapper, SistemaErrorLogSearchRepository sistemaErrorLogSearchRepository) {
        this.sistemaErrorLogRepository = sistemaErrorLogRepository;
        this.sistemaErrorLogMapper = sistemaErrorLogMapper;
        this.sistemaErrorLogSearchRepository = sistemaErrorLogSearchRepository;
    }

    /**
     * Save a sistemaErrorLog.
     *
     * @param sistemaErrorLogDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public SistemaErrorLogDTO save(SistemaErrorLogDTO sistemaErrorLogDTO) {
        log.debug("Request to save SistemaErrorLog : {}", sistemaErrorLogDTO);
        SistemaErrorLog sistemaErrorLog = sistemaErrorLogMapper.toEntity(sistemaErrorLogDTO);
        sistemaErrorLog = sistemaErrorLogRepository.save(sistemaErrorLog);
        SistemaErrorLogDTO result = sistemaErrorLogMapper.toDto(sistemaErrorLog);
        sistemaErrorLogSearchRepository.save(sistemaErrorLog);
        return result;
    }

    /**
     * Get all the sistemaErrorLogs.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<SistemaErrorLogDTO> findAll(Pageable pageable) {
        log.debug("Request to get all SistemaErrorLogs");
        return sistemaErrorLogRepository.findAll(pageable)
            .map(sistemaErrorLogMapper::toDto);
    }

    /**
     * Get one sistemaErrorLog by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public SistemaErrorLogDTO findOne(Long id) {
        log.debug("Request to get SistemaErrorLog : {}", id);
        SistemaErrorLog sistemaErrorLog = sistemaErrorLogRepository.findOne(id);
        return sistemaErrorLogMapper.toDto(sistemaErrorLog);
    }

    /**
     * Delete the sistemaErrorLog by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete SistemaErrorLog : {}", id);
        sistemaErrorLogRepository.delete(id);
        sistemaErrorLogSearchRepository.delete(id);
    }

    /**
     * Search for the sistemaErrorLog corresponding to the query.
     *
     * @param query the query of the search
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<SistemaErrorLogDTO> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of SistemaErrorLogs for query {}", query);
        Page<SistemaErrorLog> result = sistemaErrorLogSearchRepository.search(queryStringQuery(query), pageable);
        return result.map(sistemaErrorLogMapper::toDto);
    }
}
