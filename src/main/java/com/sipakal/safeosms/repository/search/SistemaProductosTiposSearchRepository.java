package com.sipakal.safeosms.repository.search;

import com.sipakal.safeosms.domain.SistemaProductosTipos;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the SistemaProductosTipos entity.
 */
public interface SistemaProductosTiposSearchRepository extends ElasticsearchRepository<SistemaProductosTipos, Long> {
}
