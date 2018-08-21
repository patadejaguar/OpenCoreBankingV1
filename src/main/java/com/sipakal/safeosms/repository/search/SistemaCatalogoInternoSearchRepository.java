package com.sipakal.safeosms.repository.search;

import com.sipakal.safeosms.domain.SistemaCatalogoInterno;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the SistemaCatalogoInterno entity.
 */
public interface SistemaCatalogoInternoSearchRepository extends ElasticsearchRepository<SistemaCatalogoInterno, Long> {
}
