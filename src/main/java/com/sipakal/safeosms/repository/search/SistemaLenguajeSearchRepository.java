package com.sipakal.safeosms.repository.search;

import com.sipakal.safeosms.domain.SistemaLenguaje;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the SistemaLenguaje entity.
 */
public interface SistemaLenguajeSearchRepository extends ElasticsearchRepository<SistemaLenguaje, Long> {
}
