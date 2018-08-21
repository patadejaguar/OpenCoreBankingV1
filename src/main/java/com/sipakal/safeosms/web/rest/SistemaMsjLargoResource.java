package com.sipakal.safeosms.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.sipakal.safeosms.service.SistemaMsjLargoService;
import com.sipakal.safeosms.web.rest.errors.BadRequestAlertException;
import com.sipakal.safeosms.web.rest.util.HeaderUtil;
import com.sipakal.safeosms.web.rest.util.PaginationUtil;
import com.sipakal.safeosms.service.dto.SistemaMsjLargoDTO;
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
 * REST controller for managing SistemaMsjLargo.
 */
@RestController
@RequestMapping("/api")
public class SistemaMsjLargoResource {

    private final Logger log = LoggerFactory.getLogger(SistemaMsjLargoResource.class);

    private static final String ENTITY_NAME = "sistemaMsjLargo";

    private final SistemaMsjLargoService sistemaMsjLargoService;

    public SistemaMsjLargoResource(SistemaMsjLargoService sistemaMsjLargoService) {
        this.sistemaMsjLargoService = sistemaMsjLargoService;
    }

    /**
     * POST  /sistema-msj-largos : Create a new sistemaMsjLargo.
     *
     * @param sistemaMsjLargoDTO the sistemaMsjLargoDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new sistemaMsjLargoDTO, or with status 400 (Bad Request) if the sistemaMsjLargo has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/sistema-msj-largos")
    @Timed
    public ResponseEntity<SistemaMsjLargoDTO> createSistemaMsjLargo(@Valid @RequestBody SistemaMsjLargoDTO sistemaMsjLargoDTO) throws URISyntaxException {
        log.debug("REST request to save SistemaMsjLargo : {}", sistemaMsjLargoDTO);
        if (sistemaMsjLargoDTO.getId() != null) {
            throw new BadRequestAlertException("A new sistemaMsjLargo cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SistemaMsjLargoDTO result = sistemaMsjLargoService.save(sistemaMsjLargoDTO);
        return ResponseEntity.created(new URI("/api/sistema-msj-largos/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /sistema-msj-largos : Updates an existing sistemaMsjLargo.
     *
     * @param sistemaMsjLargoDTO the sistemaMsjLargoDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated sistemaMsjLargoDTO,
     * or with status 400 (Bad Request) if the sistemaMsjLargoDTO is not valid,
     * or with status 500 (Internal Server Error) if the sistemaMsjLargoDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/sistema-msj-largos")
    @Timed
    public ResponseEntity<SistemaMsjLargoDTO> updateSistemaMsjLargo(@Valid @RequestBody SistemaMsjLargoDTO sistemaMsjLargoDTO) throws URISyntaxException {
        log.debug("REST request to update SistemaMsjLargo : {}", sistemaMsjLargoDTO);
        if (sistemaMsjLargoDTO.getId() == null) {
            return createSistemaMsjLargo(sistemaMsjLargoDTO);
        }
        SistemaMsjLargoDTO result = sistemaMsjLargoService.save(sistemaMsjLargoDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, sistemaMsjLargoDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /sistema-msj-largos : get all the sistemaMsjLargos.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of sistemaMsjLargos in body
     */
    @GetMapping("/sistema-msj-largos")
    @Timed
    public ResponseEntity<List<SistemaMsjLargoDTO>> getAllSistemaMsjLargos(Pageable pageable) {
        log.debug("REST request to get a page of SistemaMsjLargos");
        Page<SistemaMsjLargoDTO> page = sistemaMsjLargoService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/sistema-msj-largos");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /sistema-msj-largos/:id : get the "id" sistemaMsjLargo.
     *
     * @param id the id of the sistemaMsjLargoDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the sistemaMsjLargoDTO, or with status 404 (Not Found)
     */
    @GetMapping("/sistema-msj-largos/{id}")
    @Timed
    public ResponseEntity<SistemaMsjLargoDTO> getSistemaMsjLargo(@PathVariable Long id) {
        log.debug("REST request to get SistemaMsjLargo : {}", id);
        SistemaMsjLargoDTO sistemaMsjLargoDTO = sistemaMsjLargoService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(sistemaMsjLargoDTO));
    }

    /**
     * DELETE  /sistema-msj-largos/:id : delete the "id" sistemaMsjLargo.
     *
     * @param id the id of the sistemaMsjLargoDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/sistema-msj-largos/{id}")
    @Timed
    public ResponseEntity<Void> deleteSistemaMsjLargo(@PathVariable Long id) {
        log.debug("REST request to delete SistemaMsjLargo : {}", id);
        sistemaMsjLargoService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/sistema-msj-largos?query=:query : search for the sistemaMsjLargo corresponding
     * to the query.
     *
     * @param query the query of the sistemaMsjLargo search
     * @param pageable the pagination information
     * @return the result of the search
     */
    @GetMapping("/_search/sistema-msj-largos")
    @Timed
    public ResponseEntity<List<SistemaMsjLargoDTO>> searchSistemaMsjLargos(@RequestParam String query, Pageable pageable) {
        log.debug("REST request to search for a page of SistemaMsjLargos for query {}", query);
        Page<SistemaMsjLargoDTO> page = sistemaMsjLargoService.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/sistema-msj-largos");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

}
