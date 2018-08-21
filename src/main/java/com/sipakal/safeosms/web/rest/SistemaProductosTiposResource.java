package com.sipakal.safeosms.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.sipakal.safeosms.service.SistemaProductosTiposService;
import com.sipakal.safeosms.web.rest.errors.BadRequestAlertException;
import com.sipakal.safeosms.web.rest.util.HeaderUtil;
import com.sipakal.safeosms.web.rest.util.PaginationUtil;
import com.sipakal.safeosms.service.dto.SistemaProductosTiposDTO;
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
 * REST controller for managing SistemaProductosTipos.
 */
@RestController
@RequestMapping("/api")
public class SistemaProductosTiposResource {

    private final Logger log = LoggerFactory.getLogger(SistemaProductosTiposResource.class);

    private static final String ENTITY_NAME = "sistemaProductosTipos";

    private final SistemaProductosTiposService sistemaProductosTiposService;

    public SistemaProductosTiposResource(SistemaProductosTiposService sistemaProductosTiposService) {
        this.sistemaProductosTiposService = sistemaProductosTiposService;
    }

    /**
     * POST  /sistema-productos-tipos : Create a new sistemaProductosTipos.
     *
     * @param sistemaProductosTiposDTO the sistemaProductosTiposDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new sistemaProductosTiposDTO, or with status 400 (Bad Request) if the sistemaProductosTipos has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/sistema-productos-tipos")
    @Timed
    public ResponseEntity<SistemaProductosTiposDTO> createSistemaProductosTipos(@Valid @RequestBody SistemaProductosTiposDTO sistemaProductosTiposDTO) throws URISyntaxException {
        log.debug("REST request to save SistemaProductosTipos : {}", sistemaProductosTiposDTO);
        if (sistemaProductosTiposDTO.getId() != null) {
            throw new BadRequestAlertException("A new sistemaProductosTipos cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SistemaProductosTiposDTO result = sistemaProductosTiposService.save(sistemaProductosTiposDTO);
        return ResponseEntity.created(new URI("/api/sistema-productos-tipos/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /sistema-productos-tipos : Updates an existing sistemaProductosTipos.
     *
     * @param sistemaProductosTiposDTO the sistemaProductosTiposDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated sistemaProductosTiposDTO,
     * or with status 400 (Bad Request) if the sistemaProductosTiposDTO is not valid,
     * or with status 500 (Internal Server Error) if the sistemaProductosTiposDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/sistema-productos-tipos")
    @Timed
    public ResponseEntity<SistemaProductosTiposDTO> updateSistemaProductosTipos(@Valid @RequestBody SistemaProductosTiposDTO sistemaProductosTiposDTO) throws URISyntaxException {
        log.debug("REST request to update SistemaProductosTipos : {}", sistemaProductosTiposDTO);
        if (sistemaProductosTiposDTO.getId() == null) {
            return createSistemaProductosTipos(sistemaProductosTiposDTO);
        }
        SistemaProductosTiposDTO result = sistemaProductosTiposService.save(sistemaProductosTiposDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, sistemaProductosTiposDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /sistema-productos-tipos : get all the sistemaProductosTipos.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of sistemaProductosTipos in body
     */
    @GetMapping("/sistema-productos-tipos")
    @Timed
    public ResponseEntity<List<SistemaProductosTiposDTO>> getAllSistemaProductosTipos(Pageable pageable) {
        log.debug("REST request to get a page of SistemaProductosTipos");
        Page<SistemaProductosTiposDTO> page = sistemaProductosTiposService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/sistema-productos-tipos");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /sistema-productos-tipos/:id : get the "id" sistemaProductosTipos.
     *
     * @param id the id of the sistemaProductosTiposDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the sistemaProductosTiposDTO, or with status 404 (Not Found)
     */
    @GetMapping("/sistema-productos-tipos/{id}")
    @Timed
    public ResponseEntity<SistemaProductosTiposDTO> getSistemaProductosTipos(@PathVariable Long id) {
        log.debug("REST request to get SistemaProductosTipos : {}", id);
        SistemaProductosTiposDTO sistemaProductosTiposDTO = sistemaProductosTiposService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(sistemaProductosTiposDTO));
    }

    /**
     * DELETE  /sistema-productos-tipos/:id : delete the "id" sistemaProductosTipos.
     *
     * @param id the id of the sistemaProductosTiposDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/sistema-productos-tipos/{id}")
    @Timed
    public ResponseEntity<Void> deleteSistemaProductosTipos(@PathVariable Long id) {
        log.debug("REST request to delete SistemaProductosTipos : {}", id);
        sistemaProductosTiposService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/sistema-productos-tipos?query=:query : search for the sistemaProductosTipos corresponding
     * to the query.
     *
     * @param query the query of the sistemaProductosTipos search
     * @param pageable the pagination information
     * @return the result of the search
     */
    @GetMapping("/_search/sistema-productos-tipos")
    @Timed
    public ResponseEntity<List<SistemaProductosTiposDTO>> searchSistemaProductosTipos(@RequestParam String query, Pageable pageable) {
        log.debug("REST request to search for a page of SistemaProductosTipos for query {}", query);
        Page<SistemaProductosTiposDTO> page = sistemaProductosTiposService.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/sistema-productos-tipos");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

}
