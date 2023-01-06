package com.fvissentini.consumerservice.wikimedia;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WikimediaRepository extends CrudRepository<WikimediaData, Long> {

}
