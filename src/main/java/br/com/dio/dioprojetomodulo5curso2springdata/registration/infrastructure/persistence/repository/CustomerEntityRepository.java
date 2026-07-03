package br.com.dio.dioprojetomodulo5curso2springdata.registration.infrastructure.persistence.repository;


import br.com.dio.dioprojetomodulo5curso2springdata.registration.infrastructure.persistence.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource
public interface CustomerEntityRepository extends PagingAndSortingRepository<Customer, UUID>, CrudRepository<Customer, UUID> {
}
