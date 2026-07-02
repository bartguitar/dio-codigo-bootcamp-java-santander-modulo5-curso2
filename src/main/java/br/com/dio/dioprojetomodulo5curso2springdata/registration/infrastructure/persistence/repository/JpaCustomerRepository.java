package br.com.dio.dioprojetomodulo5curso2springdata.registration.infrastructure.persistence.repository;

import br.com.dio.dioprojetomodulo5curso2springdata.registration.domain.Customer;
import br.com.dio.dioprojetomodulo5curso2springdata.registration.domain.CustomerRepository;

import java.util.List;

public class JpaCustomerRepository implements CustomerRepository {
    @Override
    public Customer save(Customer customer) {
        return null;
    }

    @Override
    public List<Customer> findAll() {
        return List.of();
    }
}
