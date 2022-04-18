package com.example.users.crud.service.impl;

import com.example.users.crud.UserRepository;
import com.example.users.crud.io.entity.UserEntity;
import com.example.users.crud.service.UserService;
import com.example.users.crud.shared.Utils;
import com.example.users.crud.shared.dto.UserDto;
import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils utils;

    @Override
    public UserDto createUser(UserDto user) {

        if(userRepository.findByEmail(user.getEmail()) != null) throw new RuntimeException("Record already exists");
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        String publicUserId = utils.generateUserId(30);
        System.out.println(publicUserId);
        userEntity.setEncryptedPassword("sofia");
        userEntity.setUserId(publicUserId);
        UserEntity storedUserDetails = userRepository.save(userEntity);

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(storedUserDetails, returnValue);
        return returnValue;
    }
}
