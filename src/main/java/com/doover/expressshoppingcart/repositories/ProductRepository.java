package com.doover.expressshoppingcart.repositories;

import com.doover.expressshoppingcart.models.entities.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {



}
