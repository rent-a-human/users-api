package com.example.users.crud;

import com.example.users.crud.io.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<UserEntity, Long> {
    //comment: Taken
}
