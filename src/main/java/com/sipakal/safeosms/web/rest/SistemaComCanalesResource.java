package com.sipakal.safeosms.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.sipakal.safeosms.service.SistemaComCanalesService;
import com.sipakal.safeosms.web.rest.errors.BadRequestAlertException;
import com.sipakal.safeosms.web.rest.util.HeaderUtil;
import com.sipakal.safeosms.web.rest.util.PaginationUtil;
import com.sipakal.safeosms.service.dto.SistemaComCanalesDTO;
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
 * REST controller for managing SistemaComCanales.
 */
@RestController
@RequestMapping("/api")
public class SistemaComCanalesResource {

    private final Logger log = LoggerFactory.getLogger(SistemaComCanalesResource.class);

    private static final String ENTITY_NAME = "sistemaComCanales";

    private final SistemaComCanalesService sistemaComCanalesService;

    public SistemaComCanalesResource(SistemaComCanalesService sistemaComCanalesService) {
        this.sistemaComCanalesService = sistemaComCanalesService;
    }

    /**
     * POST  /sistema-com-canales : Create a new sistemaComCanales.
     *
     * @param sistemaComCanalesDTO the sistemaComCanalesDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new sistemaComCanalesDTO, or with status 400 (Bad Request) if the sistemaComCanales has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/sistema-com-canales")
    @Timed
    public ResponseEntity<SistemaComCanalesDTO> createSistemaComCanales(@Valid @RequestBody SistemaComCanalesDTO sistemaComCanalesDTO) throws URISyntaxException {
        log.debug("REST request to save SistemaComCanales : {}", sistemaComCanalesDTO);
        if (sistemaComCanalesDTO.getId() != null) {
            throw new BadRequestAlertException("A new sistemaComCanales cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SistemaComCanalesDTO result = sistemaComCanalesService.save(sistemaComCanalesDTO);
        return ResponseEntity.created(new URI("/api/sistema-com-canales/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /sistema-com-canales : Updates an existing sistemaComCanales.
     *
     * @param sistemaComCanalesDTO the sistemaComCanalesDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated sistemaComCanalesDTO,
     * or with status 400 (Bad Request) if the sistemaComCanalesDTO is not valid,
     * or with status 500 (Internal Server Error) if the sistemaComCanalesDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/sistema-com-canales")
    @Timed
    public ResponseEntity<SistemaComCanalesDTO> updateSistemaComCanales(@Valid @RequestBody SistemaComCanalesDTO sistemaComCanalesDTO) throws URISyntaxException {
        log.debug("REST request to update SistemaComCanales : {}", sistemaComCanalesDTO);
        if (sistemaComCanalesDTO.getId() == null) {
            return createSistemaComCanales(sistemaComCanalesDTO);
        }
        SistemaComCanalesDTO result = sistemaComCanalesService.save(sistemaComCanalesDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, sistemaComCanalesDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /sistema-com-canales : get all the sistemaComCanales.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of sistemaComCanales in body
     */
    @GetMapping("/sistema-com-canales")
    @Timed
    public ResponseEntity<List<SistemaComCanalesDTO>> getAllSistemaComCanales(Pageable pageable) {
        log.debug("REST request to get a page of SistemaComCanales");
        Page<SistemaComCanalesDTO> page = sistemaComCanalesService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/sistema-com-canales");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /sistema-com-canales/:id : get the "id" sistemaComCanales.
     *
     * @param id the id of the sistemaComCanalesDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the sistemaComCanalesDTO, or with status 404 (Not Found)
     */
    @GetMapping("/sistema-com-canales/{id}")
    @Timed
    public ResponseEntity<SistemaComCanalesDTO> getSistemaComCanales(@PathVariable Long id) {
        log.debug("REST request to get SistemaComCanales : {}", id);
        SistemaComCanalesDTO sistemaComCanalesDTO = sistemaComCanalesService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(sistemaComCanalesDTO));
    }

    /**
     * DELETE  /sistema-com-canales/:id : delete the "id" sistemaComCanales.
     *
     * @param id the id of the sistemaComCanalesDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/sistema-com-canales/{id}")
    @Timed
    public ResponseEntity<Void> deleteSistemaComCanales(@PathVariable Long id) {
        log.debug("REST request to delete SistemaComCanales : {}", id);
        sistemaComCanalesService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/sistema-com-canales?query=:query : search for the sistemaComCanales corresponding
     * to the query.
     *
     * @param query the query of the sistemaComCanales search
     * @param pageable the pagination information
     * @return the result of the search
     */
    @GetMapping("/_search/sistema-com-canales")
    @Timed
    public ResponseEntity<List<SistemaComCanalesDTO>> searchSistemaComCanales(@RequestParam String query, Pageable pageable) {
        log.debug("REST request to search for a page of SistemaComCanales for query {}", query);
        Page<SistemaComCanalesDTO> page = sistemaComCanalesService.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/sistema-com-canales");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

}
