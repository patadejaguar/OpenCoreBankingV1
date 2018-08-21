package com.sipakal.safeosms.repository.search;

import com.sipakal.safeosms.domain.SistemaMsjLargo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the SistemaMsjLargo entity.
 */
public interface SistemaMsjLargoSearchRepository extends ElasticsearchRepository<SistemaMsjLargo, Long> {
}
