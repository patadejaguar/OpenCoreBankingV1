package com.sipakal.safeosms.repository.search;

import com.sipakal.safeosms.domain.SistemaConfiguracion;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the SistemaConfiguracion entity.
 */
public interface SistemaConfiguracionSearchRepository extends ElasticsearchRepository<SistemaConfiguracion, Long> {
}
