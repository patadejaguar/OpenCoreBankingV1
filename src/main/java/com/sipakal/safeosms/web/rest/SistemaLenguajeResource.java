package com.sipakal.safeosms.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.sipakal.safeosms.service.SistemaLenguajeService;
import com.sipakal.safeosms.web.rest.errors.BadRequestAlertException;
import com.sipakal.safeosms.web.rest.util.HeaderUtil;
import com.sipakal.safeosms.web.rest.util.PaginationUtil;
import com.sipakal.safeosms.service.dto.SistemaLenguajeDTO;
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
 * REST controller for managing SistemaLenguaje.
 */
@RestController
@RequestMapping("/api")
public class SistemaLenguajeResource {

    private final Logger log = LoggerFactory.getLogger(SistemaLenguajeResource.class);

    private static final String ENTITY_NAME = "sistemaLenguaje";

    private final SistemaLenguajeService sistemaLenguajeService;

    public SistemaLenguajeResource(SistemaLenguajeService sistemaLenguajeService) {
        this.sistemaLenguajeService = sistemaLenguajeService;
    }

    /**
     * POST  /sistema-lenguajes : Create a new sistemaLenguaje.
     *
     * @param sistemaLenguajeDTO the sistemaLenguajeDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new sistemaLenguajeDTO, or with status 400 (Bad Request) if the sistemaLenguaje has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/sistema-lenguajes")
    @Timed
    public ResponseEntity<SistemaLenguajeDTO> createSistemaLenguaje(@Valid @RequestBody SistemaLenguajeDTO sistemaLenguajeDTO) throws URISyntaxException {
        log.debug("REST request to save SistemaLenguaje : {}", sistemaLenguajeDTO);
        if (sistemaLenguajeDTO.getId() != null) {
            throw new BadRequestAlertException("A new sistemaLenguaje cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SistemaLenguajeDTO result = sistemaLenguajeService.save(sistemaLenguajeDTO);
        return ResponseEntity.created(new URI("/api/sistema-lenguajes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /sistema-lenguajes : Updates an existing sistemaLenguaje.
     *
     * @param sistemaLenguajeDTO the sistemaLenguajeDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated sistemaLenguajeDTO,
     * or with status 400 (Bad Request) if the sistemaLenguajeDTO is not valid,
     * or with status 500 (Internal Server Error) if the sistemaLenguajeDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/sistema-lenguajes")
    @Timed
    public ResponseEntity<SistemaLenguajeDTO> updateSistemaLenguaje(@Valid @RequestBody SistemaLenguajeDTO sistemaLenguajeDTO) throws URISyntaxException {
        log.debug("REST request to update SistemaLenguaje : {}", sistemaLenguajeDTO);
        if (sistemaLenguajeDTO.getId() == null) {
            return createSistemaLenguaje(sistemaLenguajeDTO);
        }
        SistemaLenguajeDTO result = sistemaLenguajeService.save(sistemaLenguajeDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, sistemaLenguajeDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /sistema-lenguajes : get all the sistemaLenguajes.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of sistemaLenguajes in body
     */
    @GetMapping("/sistema-lenguajes")
    @Timed
    public ResponseEntity<List<SistemaLenguajeDTO>> getAllSistemaLenguajes(Pageable pageable) {
        log.debug("REST request to get a page of SistemaLenguajes");
        Page<SistemaLenguajeDTO> page = sistemaLenguajeService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/sistema-lenguajes");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /sistema-lenguajes/:id : get the "id" sistemaLenguaje.
     *
     * @param id the id of the sistemaLenguajeDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the sistemaLenguajeDTO, or with status 404 (Not Found)
     */
    @GetMapping("/sistema-lenguajes/{id}")
    @Timed
    public ResponseEntity<SistemaLenguajeDTO> getSistemaLenguaje(@PathVariable Long id) {
        log.debug("REST request to get SistemaLenguaje : {}", id);
        SistemaLenguajeDTO sistemaLenguajeDTO = sistemaLenguajeService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(sistemaLenguajeDTO));
    }

    /**
     * DELETE  /sistema-lenguajes/:id : delete the "id" sistemaLenguaje.
     *
     * @param id the id of the sistemaLenguajeDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/sistema-lenguajes/{id}")
    @Timed
    public ResponseEntity<Void> deleteSistemaLenguaje(@PathVariable Long id) {
        log.debug("REST request to delete SistemaLenguaje : {}", id);
        sistemaLenguajeService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/sistema-lenguajes?query=:query : search for the sistemaLenguaje corresponding
     * to the query.
     *
     * @param query the query of the sistemaLenguaje search
     * @param pageable the pagination information
     * @return the result of the search
     */
    @GetMapping("/_search/sistema-lenguajes")
    @Timed
    public ResponseEntity<List<SistemaLenguajeDTO>> searchSistemaLenguajes(@RequestParam String query, Pageable pageable) {
        log.debug("REST request to search for a page of SistemaLenguajes for query {}", query);
        Page<SistemaLenguajeDTO> page = sistemaLenguajeService.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/sistema-lenguajes");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

}
