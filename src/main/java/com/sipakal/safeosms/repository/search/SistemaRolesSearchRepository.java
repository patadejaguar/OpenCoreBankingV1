package com.sipakal.safeosms.repository.search;

import com.sipakal.safeosms.domain.SistemaRoles;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the SistemaRoles entity.
 */
public interface SistemaRolesSearchRepository extends ElasticsearchRepository<SistemaRoles, Long> {
}
