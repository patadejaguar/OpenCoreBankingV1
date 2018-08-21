package com.sipakal.safeosms.repository.search;

import com.sipakal.safeosms.domain.SistemaErrorLog;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the SistemaErrorLog entity.
 */
public interface SistemaErrorLogSearchRepository extends ElasticsearchRepository<SistemaErrorLog, Long> {
}
