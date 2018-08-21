package com.sipakal.safeosms.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.sipakal.safeosms.service.SistemaErrorTiposService;
import com.sipakal.safeosms.web.rest.errors.BadRequestAlertException;
import com.sipakal.safeosms.web.rest.util.HeaderUtil;
import com.sipakal.safeosms.web.rest.util.PaginationUtil;
import com.sipakal.safeosms.service.dto.SistemaErrorTiposDTO;
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
 * REST controller for managing SistemaErrorTipos.
 */
@RestController
@RequestMapping("/api")
public class SistemaErrorTiposResource {

    private final Logger log = LoggerFactory.getLogger(SistemaErrorTiposResource.class);

    private static final String ENTITY_NAME = "sistemaErrorTipos";

    private final SistemaErrorTiposService sistemaErrorTiposService;

    public SistemaErrorTiposResource(SistemaErrorTiposService sistemaErrorTiposService) {
        this.sistemaErrorTiposService = sistemaErrorTiposService;
    }

    /**
     * POST  /sistema-error-tipos : Create a new sistemaErrorTipos.
     *
     * @param sistemaErrorTiposDTO the sistemaErrorTiposDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new sistemaErrorTiposDTO, or with status 400 (Bad Request) if the sistemaErrorTipos has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/sistema-error-tipos")
    @Timed
    public ResponseEntity<SistemaErrorTiposDTO> createSistemaErrorTipos(@Valid @RequestBody SistemaErrorTiposDTO sistemaErrorTiposDTO) throws URISyntaxException {
        log.debug("REST request to save SistemaErrorTipos : {}", sistemaErrorTiposDTO);
        if (sistemaErrorTiposDTO.getId() != null) {
            throw new BadRequestAlertException("A new sistemaErrorTipos cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SistemaErrorTiposDTO result = sistemaErrorTiposService.save(sistemaErrorTiposDTO);
        return ResponseEntity.created(new URI("/api/sistema-error-tipos/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /sistema-error-tipos : Updates an existing sistemaErrorTipos.
     *
     * @param sistemaErrorTiposDTO the sistemaErrorTiposDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated sistemaErrorTiposDTO,
     * or with status 400 (Bad Request) if the sistemaErrorTiposDTO is not valid,
     * or with status 500 (Internal Server Error) if the sistemaErrorTiposDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/sistema-error-tipos")
    @Timed
    public ResponseEntity<SistemaErrorTiposDTO> updateSistemaErrorTipos(@Valid @RequestBody SistemaErrorTiposDTO sistemaErrorTiposDTO) throws URISyntaxException {
        log.debug("REST request to update SistemaErrorTipos : {}", sistemaErrorTiposDTO);
        if (sistemaErrorTiposDTO.getId() == null) {
            return createSistemaErrorTipos(sistemaErrorTiposDTO);
        }
        SistemaErrorTiposDTO result = sistemaErrorTiposService.save(sistemaErrorTiposDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, sistemaErrorTiposDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /sistema-error-tipos : get all the sistemaErrorTipos.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of sistemaErrorTipos in body
     */
    @GetMapping("/sistema-error-tipos")
    @Timed
    public ResponseEntity<List<SistemaErrorTiposDTO>> getAllSistemaErrorTipos(Pageable pageable) {
        log.debug("REST request to get a page of SistemaErrorTipos");
        Page<SistemaErrorTiposDTO> page = sistemaErrorTiposService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/sistema-error-tipos");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /sistema-error-tipos/:id : get the "id" sistemaErrorTipos.
     *
     * @param id the id of the sistemaErrorTiposDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the sistemaErrorTiposDTO, or with status 404 (Not Found)
     */
    @GetMapping("/sistema-error-tipos/{id}")
    @Timed
    public ResponseEntity<SistemaErrorTiposDTO> getSistemaErrorTipos(@PathVariable Long id) {
        log.debug("REST request to get SistemaErrorTipos : {}", id);
        SistemaErrorTiposDTO sistemaErrorTiposDTO = sistemaErrorTiposService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(sistemaErrorTiposDTO));
    }

    /**
     * DELETE  /sistema-error-tipos/:id : delete the "id" sistemaErrorTipos.
     *
     * @param id the id of the sistemaErrorTiposDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/sistema-error-tipos/{id}")
    @Timed
    public ResponseEntity<Void> deleteSistemaErrorTipos(@PathVariable Long id) {
        log.debug("REST request to delete SistemaErrorTipos : {}", id);
        sistemaErrorTiposService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/sistema-error-tipos?query=:query : search for the sistemaErrorTipos corresponding
     * to the query.
     *
     * @param query the query of the sistemaErrorTipos search
     * @param pageable the pagination information
     * @return the result of the search
     */
    @GetMapping("/_search/sistema-error-tipos")
    @Timed
    public ResponseEntity<List<SistemaErrorTiposDTO>> searchSistemaErrorTipos(@RequestParam String query, Pageable pageable) {
        log.debug("REST request to search for a page of SistemaErrorTipos for query {}", query);
        Page<SistemaErrorTiposDTO> page = sistemaErrorTiposService.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/sistema-error-tipos");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

}
