package com.sipakal.safeosms.repository.search;

import com.sipakal.safeosms.domain.SistemaComCanales;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the SistemaComCanales entity.
 */
public interface SistemaComCanalesSearchRepository extends ElasticsearchRepository<SistemaComCanales, Long> {
}
