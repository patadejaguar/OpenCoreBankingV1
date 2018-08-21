package com.sipakal.safeosms.repository.search;

import com.sipakal.safeosms.domain.SistemaErrorTipos;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the SistemaErrorTipos entity.
 */
public interface SistemaErrorTiposSearchRepository extends ElasticsearchRepository<SistemaErrorTipos, Long> {
}
