package com.sipakal.safeosms.repository.search;

import com.sipakal.safeosms.domain.SistemaNivelRiesgo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the SistemaNivelRiesgo entity.
 */
public interface SistemaNivelRiesgoSearchRepository extends ElasticsearchRepository<SistemaNivelRiesgo, Long> {
}
