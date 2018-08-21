package com.sipakal.safeosms.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.sipakal.safeosms.service.SistemaRolesService;
import com.sipakal.safeosms.web.rest.errors.BadRequestAlertException;
import com.sipakal.safeosms.web.rest.util.HeaderUtil;
import com.sipakal.safeosms.web.rest.util.PaginationUtil;
import com.sipakal.safeosms.service.dto.SistemaRolesDTO;
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
 * REST controller for managing SistemaRoles.
 */
@RestController
@RequestMapping("/api")
public class SistemaRolesResource {

    private final Logger log = LoggerFactory.getLogger(SistemaRolesResource.class);

    private static final String ENTITY_NAME = "sistemaRoles";

    private final SistemaRolesService sistemaRolesService;

    public SistemaRolesResource(SistemaRolesService sistemaRolesService) {
        this.sistemaRolesService = sistemaRolesService;
    }

    /**
     * POST  /sistema-roles : Create a new sistemaRoles.
     *
     * @param sistemaRolesDTO the sistemaRolesDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new sistemaRolesDTO, or with status 400 (Bad Request) if the sistemaRoles has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/sistema-roles")
    @Timed
    public ResponseEntity<SistemaRolesDTO> createSistemaRoles(@Valid @RequestBody SistemaRolesDTO sistemaRolesDTO) throws URISyntaxException {
        log.debug("REST request to save SistemaRoles : {}", sistemaRolesDTO);
        if (sistemaRolesDTO.getId() != null) {
            throw new BadRequestAlertException("A new sistemaRoles cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SistemaRolesDTO result = sistemaRolesService.save(sistemaRolesDTO);
        return ResponseEntity.created(new URI("/api/sistema-roles/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /sistema-roles : Updates an existing sistemaRoles.
     *
     * @param sistemaRolesDTO the sistemaRolesDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated sistemaRolesDTO,
     * or with status 400 (Bad Request) if the sistemaRolesDTO is not valid,
     * or with status 500 (Internal Server Error) if the sistemaRolesDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/sistema-roles")
    @Timed
    public ResponseEntity<SistemaRolesDTO> updateSistemaRoles(@Valid @RequestBody SistemaRolesDTO sistemaRolesDTO) throws URISyntaxException {
        log.debug("REST request to update SistemaRoles : {}", sistemaRolesDTO);
        if (sistemaRolesDTO.getId() == null) {
            return createSistemaRoles(sistemaRolesDTO);
        }
        SistemaRolesDTO result = sistemaRolesService.save(sistemaRolesDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, sistemaRolesDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /sistema-roles : get all the sistemaRoles.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of sistemaRoles in body
     */
    @GetMapping("/sistema-roles")
    @Timed
    public ResponseEntity<List<SistemaRolesDTO>> getAllSistemaRoles(Pageable pageable) {
        log.debug("REST request to get a page of SistemaRoles");
        Page<SistemaRolesDTO> page = sistemaRolesService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/sistema-roles");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /sistema-roles/:id : get the "id" sistemaRoles.
     *
     * @param id the id of the sistemaRolesDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the sistemaRolesDTO, or with status 404 (Not Found)
     */
    @GetMapping("/sistema-roles/{id}")
    @Timed
    public ResponseEntity<SistemaRolesDTO> getSistemaRoles(@PathVariable Long id) {
        log.debug("REST request to get SistemaRoles : {}", id);
        SistemaRolesDTO sistemaRolesDTO = sistemaRolesService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(sistemaRolesDTO));
    }

    /**
     * DELETE  /sistema-roles/:id : delete the "id" sistemaRoles.
     *
     * @param id the id of the sistemaRolesDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/sistema-roles/{id}")
    @Timed
    public ResponseEntity<Void> deleteSistemaRoles(@PathVariable Long id) {
        log.debug("REST request to delete SistemaRoles : {}", id);
        sistemaRolesService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/sistema-roles?query=:query : search for the sistemaRoles corresponding
     * to the query.
     *
     * @param query the query of the sistemaRoles search
     * @param pageable the pagination information
     * @return the result of the search
     */
    @GetMapping("/_search/sistema-roles")
    @Timed
    public ResponseEntity<List<SistemaRolesDTO>> searchSistemaRoles(@RequestParam String query, Pageable pageable) {
        log.debug("REST request to search for a page of SistemaRoles for query {}", query);
        Page<SistemaRolesDTO> page = sistemaRolesService.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/sistema-roles");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

}
