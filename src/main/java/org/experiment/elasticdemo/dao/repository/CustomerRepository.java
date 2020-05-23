package org.experiment.elasticdemo.dao.repository;

import org.experiment.elasticdemo.model.Customer;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends ElasticsearchRepository<Customer,Long> {
    Optional<List<Customer>> findByFirstName(String firstName);
}
