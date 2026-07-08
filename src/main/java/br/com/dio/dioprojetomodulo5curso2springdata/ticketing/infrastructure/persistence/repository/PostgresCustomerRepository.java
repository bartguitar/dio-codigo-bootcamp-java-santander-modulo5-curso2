package br.com.dio.dioprojetomodulo5curso2springdata.ticketing.infrastructure.persistence.repository;

import br.com.dio.dioprojetomodulo5curso2springdata.ticketing.domain.Customer;
import br.com.dio.dioprojetomodulo5curso2springdata.ticketing.domain.CustomerRepository;
import org.springframework.stereotype.Repository;

@Repository
public class PostgresCustomerRepository implements CustomerRepository {

    private final CustomerCrudRepository customerCrudRepository;


    public PostgresCustomerRepository(CustomerCrudRepository customerCrudRepository) {
        this.customerCrudRepository = customerCrudRepository;
    }


    @Override
    public void save(Customer customer) {

        var entity = new br.com.dio.dioprojetomodulo5curso2springdata.ticketing.infrastructure.persistence.entity.Customer(
                customer.getId(),
                customer.getCorrelationId().id(),
                customer.getName()
        );
        customerCrudRepository.save(entity);

    }
}
