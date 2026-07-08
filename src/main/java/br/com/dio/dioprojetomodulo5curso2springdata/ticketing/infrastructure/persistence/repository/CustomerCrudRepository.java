package br.com.dio.dioprojetomodulo5curso2springdata.ticketing.infrastructure.persistence.repository;

import br.com.dio.dioprojetomodulo5curso2springdata.ticketing.infrastructure.persistence.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(exported = false, path = "_customer")
public interface CustomerCrudRepository extends CrudRepository<Customer, UUID> {
}
