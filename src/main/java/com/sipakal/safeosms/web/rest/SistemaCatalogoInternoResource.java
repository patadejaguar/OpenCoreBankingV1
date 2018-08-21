package com.sipakal.safeosms.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.sipakal.safeosms.service.SistemaCatalogoInternoService;
import com.sipakal.safeosms.web.rest.errors.BadRequestAlertException;
import com.sipakal.safeosms.web.rest.util.HeaderUtil;
import com.sipakal.safeosms.web.rest.util.PaginationUtil;
import com.sipakal.safeosms.service.dto.SistemaCatalogoInternoDTO;
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
 * REST controller for managing SistemaCatalogoInterno.
 */
@RestController
@RequestMapping("/api")
public class SistemaCatalogoInternoResource {

    private final Logger log = LoggerFactory.getLogger(SistemaCatalogoInternoResource.class);

    private static final String ENTITY_NAME = "sistemaCatalogoInterno";

    private final SistemaCatalogoInternoService sistemaCatalogoInternoService;

    public SistemaCatalogoInternoResource(SistemaCatalogoInternoService sistemaCatalogoInternoService) {
        this.sistemaCatalogoInternoService = sistemaCatalogoInternoService;
    }

    /**
     * POST  /sistema-catalogo-internos : Create a new sistemaCatalogoInterno.
     *
     * @param sistemaCatalogoInternoDTO the sistemaCatalogoInternoDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new sistemaCatalogoInternoDTO, or with status 400 (Bad Request) if the sistemaCatalogoInterno has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/sistema-catalogo-internos")
    @Timed
    public ResponseEntity<SistemaCatalogoInternoDTO> createSistemaCatalogoInterno(@Valid @RequestBody SistemaCatalogoInternoDTO sistemaCatalogoInternoDTO) throws URISyntaxException {
        log.debug("REST request to save SistemaCatalogoInterno : {}", sistemaCatalogoInternoDTO);
        if (sistemaCatalogoInternoDTO.getId() != null) {
            throw new BadRequestAlertException("A new sistemaCatalogoInterno cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SistemaCatalogoInternoDTO result = sistemaCatalogoInternoService.save(sistemaCatalogoInternoDTO);
        return ResponseEntity.created(new URI("/api/sistema-catalogo-internos/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /sistema-catalogo-internos : Updates an existing sistemaCatalogoInterno.
     *
     * @param sistemaCatalogoInternoDTO the sistemaCatalogoInternoDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated sistemaCatalogoInternoDTO,
     * or with status 400 (Bad Request) if the sistemaCatalogoInternoDTO is not valid,
     * or with status 500 (Internal Server Error) if the sistemaCatalogoInternoDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/sistema-catalogo-internos")
    @Timed
    public ResponseEntity<SistemaCatalogoInternoDTO> updateSistemaCatalogoInterno(@Valid @RequestBody SistemaCatalogoInternoDTO sistemaCatalogoInternoDTO) throws URISyntaxException {
        log.debug("REST request to update SistemaCatalogoInterno : {}", sistemaCatalogoInternoDTO);
        if (sistemaCatalogoInternoDTO.getId() == null) {
            return createSistemaCatalogoInterno(sistemaCatalogoInternoDTO);
        }
        SistemaCatalogoInternoDTO result = sistemaCatalogoInternoService.save(sistemaCatalogoInternoDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, sistemaCatalogoInternoDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /sistema-catalogo-internos : get all the sistemaCatalogoInternos.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of sistemaCatalogoInternos in body
     */
    @GetMapping("/sistema-catalogo-internos")
    @Timed
    public ResponseEntity<List<SistemaCatalogoInternoDTO>> getAllSistemaCatalogoInternos(Pageable pageable) {
        log.debug("REST request to get a page of SistemaCatalogoInternos");
        Page<SistemaCatalogoInternoDTO> page = sistemaCatalogoInternoService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/sistema-catalogo-internos");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /sistema-catalogo-internos/:id : get the "id" sistemaCatalogoInterno.
     *
     * @param id the id of the sistemaCatalogoInternoDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the sistemaCatalogoInternoDTO, or with status 404 (Not Found)
     */
    @GetMapping("/sistema-catalogo-internos/{id}")
    @Timed
    public ResponseEntity<SistemaCatalogoInternoDTO> getSistemaCatalogoInterno(@PathVariable Long id) {
        log.debug("REST request to get SistemaCatalogoInterno : {}", id);
        SistemaCatalogoInternoDTO sistemaCatalogoInternoDTO = sistemaCatalogoInternoService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(sistemaCatalogoInternoDTO));
    }

    /**
     * DELETE  /sistema-catalogo-internos/:id : delete the "id" sistemaCatalogoInterno.
     *
     * @param id the id of the sistemaCatalogoInternoDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/sistema-catalogo-internos/{id}")
    @Timed
    public ResponseEntity<Void> deleteSistemaCatalogoInterno(@PathVariable Long id) {
        log.debug("REST request to delete SistemaCatalogoInterno : {}", id);
        sistemaCatalogoInternoService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/sistema-catalogo-internos?query=:query : search for the sistemaCatalogoInterno corresponding
     * to the query.
     *
     * @param query the query of the sistemaCatalogoInterno search
     * @param pageable the pagination information
     * @return the result of the search
     */
    @GetMapping("/_search/sistema-catalogo-internos")
    @Timed
    public ResponseEntity<List<SistemaCatalogoInternoDTO>> searchSistemaCatalogoInternos(@RequestParam String query, Pageable pageable) {
        log.debug("REST request to search for a page of SistemaCatalogoInternos for query {}", query);
        Page<SistemaCatalogoInternoDTO> page = sistemaCatalogoInternoService.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/sistema-catalogo-internos");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

}
