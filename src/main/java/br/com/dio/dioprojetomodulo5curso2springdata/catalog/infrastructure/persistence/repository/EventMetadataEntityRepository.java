package br.com.dio.dioprojetomodulo5curso2springdata.catalog.infrastructure.persistence.repository;

import br.com.dio.dioprojetomodulo5curso2springdata.catalog.infrastructure.persistence.entity.EventMetadata;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EventMetadataEntityRepository extends MongoRepository<EventMetadata, String> {
}
