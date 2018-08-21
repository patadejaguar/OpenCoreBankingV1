package com.sipakal.safeosms.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.sipakal.safeosms.service.SistemaErrorLogService;
import com.sipakal.safeosms.web.rest.errors.BadRequestAlertException;
import com.sipakal.safeosms.web.rest.util.HeaderUtil;
import com.sipakal.safeosms.web.rest.util.PaginationUtil;
import com.sipakal.safeosms.service.dto.SistemaErrorLogDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * REST controller for managing SistemaErrorLog.
 */
@RestController
@RequestMapping("/api")
public class SistemaErrorLogResource {

    private final Logger log = LoggerFactory.getLogger(SistemaErrorLogResource.class);

    private static final String ENTITY_NAME = "sistemaErrorLog";

    private final SistemaErrorLogService sistemaErrorLogService;

    public SistemaErrorLogResource(SistemaErrorLogService sistemaErrorLogService) {
        this.sistemaErrorLogService = sistemaErrorLogService;
    }

    /**
     * POST  /sistema-error-logs : Create a new sistemaErrorLog.
     *
     * @param sistemaErrorLogDTO the sistemaErrorLogDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new sistemaErrorLogDTO, or with status 400 (Bad Request) if the sistemaErrorLog has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/sistema-error-logs")
    @Timed
    public ResponseEntity<SistemaErrorLogDTO> createSistemaErrorLog(@Valid @RequestBody SistemaErrorLogDTO sistemaErrorLogDTO) throws URISyntaxException {
        log.debug("REST request to save SistemaErrorLog : {}", sistemaErrorLogDTO);
        if (sistemaErrorLogDTO.getId() != null) {
            throw new BadRequestAlertException("A new sistemaErrorLog cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SistemaErrorLogDTO result = sistemaErrorLogService.save(sistemaErrorLogDTO);
        return ResponseEntity.created(new URI("/api/sistema-error-logs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /sistema-error-logs : Updates an existing sistemaErrorLog.
     *
     * @param sistemaErrorLogDTO the sistemaErrorLogDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated sistemaErrorLogDTO,
     * or with status 400 (Bad Request) if the sistemaErrorLogDTO is not valid,
     * or with status 500 (Internal Server Error) if the sistemaErrorLogDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/sistema-error-logs")
    @Timed
    public ResponseEntity<SistemaErrorLogDTO> updateSistemaErrorLog(@Valid @RequestBody SistemaErrorLogDTO sistemaErrorLogDTO) throws URISyntaxException {
        log.debug("REST request to update SistemaErrorLog : {}", sistemaErrorLogDTO);
        if (sistemaErrorLogDTO.getId() == null) {
            return createSistemaErrorLog(sistemaErrorLogDTO);
        }
        SistemaErrorLogDTO result = sistemaErrorLogService.save(sistemaErrorLogDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, sistemaErrorLogDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /sistema-error-logs : get all the sistemaErrorLogs.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of sistemaErrorLogs in body
     */
    @GetMapping("/sistema-error-logs")
    @Timed
    public ResponseEntity<List<SistemaErrorLogDTO>> getAllSistemaErrorLogs(Pageable pageable) {
        log.debug("REST request to get a page of SistemaErrorLogs");
        Page<SistemaErrorLogDTO> page = sistemaErrorLogService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/sistema-error-logs");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /sistema-error-logs/:id : get the "id" sistemaErrorLog.
     *
     * @param id the id of the sistemaErrorLogDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the sistemaErrorLogDTO, or with status 404 (Not Found)
     */
    @GetMapping("/sistema-error-logs/{id}")
    @Timed
    public ResponseEntity<SistemaErrorLogDTO> getSistemaErrorLog(@PathVariable Long id) {
        log.debug("REST request to get SistemaErrorLog : {}", id);
        SistemaErrorLogDTO sistemaErrorLogDTO = sistemaErrorLogService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(sistemaErrorLogDTO));
    }

    /**
     * DELETE  /sistema-error-logs/:id : delete the "id" sistemaErrorLog.
     *
     * @param id the id of the sistemaErrorLogDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/sistema-error-logs/{id}")
    @Timed
    public ResponseEntity<Void> deleteSistemaErrorLog(@PathVariable Long id) {
        log.debug("REST request to delete SistemaErrorLog : {}", id);
        sistemaErrorLogService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/sistema-error-logs?query=:query : search for the sistemaErrorLog corresponding
     * to the query.
     *
     * @param query the query of the sistemaErrorLog search
     * @param pageable the pagination information
     * @return the result of the search
     */
    @GetMapping("/_search/sistema-error-logs")
    @Timed
    public ResponseEntity<List<SistemaErrorLogDTO>> searchSistemaErrorLogs(@RequestParam String query, Pageable pageable) {
        log.debug("REST request to search for a page of SistemaErrorLogs for query {}", query);
        Page<SistemaErrorLogDTO> page = sistemaErrorLogService.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/sistema-error-logs");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

}
