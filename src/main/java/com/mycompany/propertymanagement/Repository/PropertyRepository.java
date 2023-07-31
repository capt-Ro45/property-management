package com.mycompany.propertymanagement.Repository;

import com.mycompany.propertymanagement.Entity.PropertyEntity;
import org.springframework.data.repository.CrudRepository;

public interface PropertyRepository extends CrudRepository<PropertyEntity,Long> {
}
