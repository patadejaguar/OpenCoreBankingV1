package com.sipakal.safeosms.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.sipakal.safeosms.service.SistemaNivelRiesgoService;
import com.sipakal.safeosms.web.rest.errors.BadRequestAlertException;
import com.sipakal.safeosms.web.rest.util.HeaderUtil;
import com.sipakal.safeosms.web.rest.util.PaginationUtil;
import com.sipakal.safeosms.service.dto.SistemaNivelRiesgoDTO;
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
 * REST controller for managing SistemaNivelRiesgo.
 */
@RestController
@RequestMapping("/api")
public class SistemaNivelRiesgoResource {

    private final Logger log = LoggerFactory.getLogger(SistemaNivelRiesgoResource.class);

    private static final String ENTITY_NAME = "sistemaNivelRiesgo";

    private final SistemaNivelRiesgoService sistemaNivelRiesgoService;

    public SistemaNivelRiesgoResource(SistemaNivelRiesgoService sistemaNivelRiesgoService) {
        this.sistemaNivelRiesgoService = sistemaNivelRiesgoService;
    }

    /**
     * POST  /sistema-nivel-riesgos : Create a new sistemaNivelRiesgo.
     *
     * @param sistemaNivelRiesgoDTO the sistemaNivelRiesgoDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new sistemaNivelRiesgoDTO, or with status 400 (Bad Request) if the sistemaNivelRiesgo has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/sistema-nivel-riesgos")
    @Timed
    public ResponseEntity<SistemaNivelRiesgoDTO> createSistemaNivelRiesgo(@Valid @RequestBody SistemaNivelRiesgoDTO sistemaNivelRiesgoDTO) throws URISyntaxException {
        log.debug("REST request to save SistemaNivelRiesgo : {}", sistemaNivelRiesgoDTO);
        if (sistemaNivelRiesgoDTO.getId() != null) {
            throw new BadRequestAlertException("A new sistemaNivelRiesgo cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SistemaNivelRiesgoDTO result = sistemaNivelRiesgoService.save(sistemaNivelRiesgoDTO);
        return ResponseEntity.created(new URI("/api/sistema-nivel-riesgos/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /sistema-nivel-riesgos : Updates an existing sistemaNivelRiesgo.
     *
     * @param sistemaNivelRiesgoDTO the sistemaNivelRiesgoDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated sistemaNivelRiesgoDTO,
     * or with status 400 (Bad Request) if the sistemaNivelRiesgoDTO is not valid,
     * or with status 500 (Internal Server Error) if the sistemaNivelRiesgoDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/sistema-nivel-riesgos")
    @Timed
    public ResponseEntity<SistemaNivelRiesgoDTO> updateSistemaNivelRiesgo(@Valid @RequestBody SistemaNivelRiesgoDTO sistemaNivelRiesgoDTO) throws URISyntaxException {
        log.debug("REST request to update SistemaNivelRiesgo : {}", sistemaNivelRiesgoDTO);
        if (sistemaNivelRiesgoDTO.getId() == null) {
            return createSistemaNivelRiesgo(sistemaNivelRiesgoDTO);
        }
        SistemaNivelRiesgoDTO result = sistemaNivelRiesgoService.save(sistemaNivelRiesgoDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, sistemaNivelRiesgoDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /sistema-nivel-riesgos : get all the sistemaNivelRiesgos.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of sistemaNivelRiesgos in body
     */
    @GetMapping("/sistema-nivel-riesgos")
    @Timed
    public ResponseEntity<List<SistemaNivelRiesgoDTO>> getAllSistemaNivelRiesgos(Pageable pageable) {
        log.debug("REST request to get a page of SistemaNivelRiesgos");
        Page<SistemaNivelRiesgoDTO> page = sistemaNivelRiesgoService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/sistema-nivel-riesgos");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /sistema-nivel-riesgos/:id : get the "id" sistemaNivelRiesgo.
     *
     * @param id the id of the sistemaNivelRiesgoDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the sistemaNivelRiesgoDTO, or with status 404 (Not Found)
     */
    @GetMapping("/sistema-nivel-riesgos/{id}")
    @Timed
    public ResponseEntity<SistemaNivelRiesgoDTO> getSistemaNivelRiesgo(@PathVariable Long id) {
        log.debug("REST request to get SistemaNivelRiesgo : {}", id);
        SistemaNivelRiesgoDTO sistemaNivelRiesgoDTO = sistemaNivelRiesgoService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(sistemaNivelRiesgoDTO));
    }

    /**
     * DELETE  /sistema-nivel-riesgos/:id : delete the "id" sistemaNivelRiesgo.
     *
     * @param id the id of the sistemaNivelRiesgoDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/sistema-nivel-riesgos/{id}")
    @Timed
    public ResponseEntity<Void> deleteSistemaNivelRiesgo(@PathVariable Long id) {
        log.debug("REST request to delete SistemaNivelRiesgo : {}", id);
        sistemaNivelRiesgoService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/sistema-nivel-riesgos?query=:query : search for the sistemaNivelRiesgo corresponding
     * to the query.
     *
     * @param query the query of the sistemaNivelRiesgo search
     * @param pageable the pagination information
     * @return the result of the search
     */
    @GetMapping("/_search/sistema-nivel-riesgos")
    @Timed
    public ResponseEntity<List<SistemaNivelRiesgoDTO>> searchSistemaNivelRiesgos(@RequestParam String query, Pageable pageable) {
        log.debug("REST request to search for a page of SistemaNivelRiesgos for query {}", query);
        Page<SistemaNivelRiesgoDTO> page = sistemaNivelRiesgoService.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/sistema-nivel-riesgos");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

}
