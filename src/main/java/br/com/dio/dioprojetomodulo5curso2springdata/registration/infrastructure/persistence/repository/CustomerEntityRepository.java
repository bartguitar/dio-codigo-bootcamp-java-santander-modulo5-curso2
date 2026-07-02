package br.com.dio.dioprojetomodulo5curso2springdata.registration.infrastructure.persistence.repository;


import br.com.dio.dioprojetomodulo5curso2springdata.registration.infrastructure.persistence.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CustomerEntityRepository extends CrudRepository<Customer, UUID> {
}
