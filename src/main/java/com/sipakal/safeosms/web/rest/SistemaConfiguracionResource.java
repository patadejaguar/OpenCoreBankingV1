package com.sipakal.safeosms.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.sipakal.safeosms.service.SistemaConfiguracionService;
import com.sipakal.safeosms.web.rest.errors.BadRequestAlertException;
import com.sipakal.safeosms.web.rest.util.HeaderUtil;
import com.sipakal.safeosms.web.rest.util.PaginationUtil;
import com.sipakal.safeosms.service.dto.SistemaConfiguracionDTO;
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
 * REST controller for managing SistemaConfiguracion.
 */
@RestController
@RequestMapping("/api")
public class SistemaConfiguracionResource {

    private final Logger log = LoggerFactory.getLogger(SistemaConfiguracionResource.class);

    private static final String ENTITY_NAME = "sistemaConfiguracion";

    private final SistemaConfiguracionService sistemaConfiguracionService;

    public SistemaConfiguracionResource(SistemaConfiguracionService sistemaConfiguracionService) {
        this.sistemaConfiguracionService = sistemaConfiguracionService;
    }

    /**
     * POST  /sistema-configuracions : Create a new sistemaConfiguracion.
     *
     * @param sistemaConfiguracionDTO the sistemaConfiguracionDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new sistemaConfiguracionDTO, or with status 400 (Bad Request) if the sistemaConfiguracion has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/sistema-configuracions")
    @Timed
    public ResponseEntity<SistemaConfiguracionDTO> createSistemaConfiguracion(@Valid @RequestBody SistemaConfiguracionDTO sistemaConfiguracionDTO) throws URISyntaxException {
        log.debug("REST request to save SistemaConfiguracion : {}", sistemaConfiguracionDTO);
        if (sistemaConfiguracionDTO.getId() != null) {
            throw new BadRequestAlertException("A new sistemaConfiguracion cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SistemaConfiguracionDTO result = sistemaConfiguracionService.save(sistemaConfiguracionDTO);
        return ResponseEntity.created(new URI("/api/sistema-configuracions/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /sistema-configuracions : Updates an existing sistemaConfiguracion.
     *
     * @param sistemaConfiguracionDTO the sistemaConfiguracionDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated sistemaConfiguracionDTO,
     * or with status 400 (Bad Request) if the sistemaConfiguracionDTO is not valid,
     * or with status 500 (Internal Server Error) if the sistemaConfiguracionDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/sistema-configuracions")
    @Timed
    public ResponseEntity<SistemaConfiguracionDTO> updateSistemaConfiguracion(@Valid @RequestBody SistemaConfiguracionDTO sistemaConfiguracionDTO) throws URISyntaxException {
        log.debug("REST request to update SistemaConfiguracion : {}", sistemaConfiguracionDTO);
        if (sistemaConfiguracionDTO.getId() == null) {
            return createSistemaConfiguracion(sistemaConfiguracionDTO);
        }
        SistemaConfiguracionDTO result = sistemaConfiguracionService.save(sistemaConfiguracionDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, sistemaConfiguracionDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /sistema-configuracions : get all the sistemaConfiguracions.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of sistemaConfiguracions in body
     */
    @GetMapping("/sistema-configuracions")
    @Timed
    public ResponseEntity<List<SistemaConfiguracionDTO>> getAllSistemaConfiguracions(Pageable pageable) {
        log.debug("REST request to get a page of SistemaConfiguracions");
        Page<SistemaConfiguracionDTO> page = sistemaConfiguracionService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/sistema-configuracions");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /sistema-configuracions/:id : get the "id" sistemaConfiguracion.
     *
     * @param id the id of the sistemaConfiguracionDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the sistemaConfiguracionDTO, or with status 404 (Not Found)
     */
    @GetMapping("/sistema-configuracions/{id}")
    @Timed
    public ResponseEntity<SistemaConfiguracionDTO> getSistemaConfiguracion(@PathVariable Long id) {
        log.debug("REST request to get SistemaConfiguracion : {}", id);
        SistemaConfiguracionDTO sistemaConfiguracionDTO = sistemaConfiguracionService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(sistemaConfiguracionDTO));
    }

    /**
     * DELETE  /sistema-configuracions/:id : delete the "id" sistemaConfiguracion.
     *
     * @param id the id of the sistemaConfiguracionDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/sistema-configuracions/{id}")
    @Timed
    public ResponseEntity<Void> deleteSistemaConfiguracion(@PathVariable Long id) {
        log.debug("REST request to delete SistemaConfiguracion : {}", id);
        sistemaConfiguracionService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/sistema-configuracions?query=:query : search for the sistemaConfiguracion corresponding
     * to the query.
     *
     * @param query the query of the sistemaConfiguracion search
     * @param pageable the pagination information
     * @return the result of the search
     */
    @GetMapping("/_search/sistema-configuracions")
    @Timed
    public ResponseEntity<List<SistemaConfiguracionDTO>> searchSistemaConfiguracions(@RequestParam String query, Pageable pageable) {
        log.debug("REST request to search for a page of SistemaConfiguracions for query {}", query);
        Page<SistemaConfiguracionDTO> page = sistemaConfiguracionService.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/sistema-configuracions");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

}
