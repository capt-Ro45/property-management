package com.mycompany.propertymanagement.Repository;


import com.mycompany.propertymanagement.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity,Long> {
}
