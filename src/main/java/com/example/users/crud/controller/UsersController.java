package com.example.users.crud.controller;

import com.example.users.crud.service.UserService;
import com.example.users.crud.shared.dto.UserDto;
import com.example.users.crud.ui.model.request.UserRequestModel;
import com.example.users.crud.ui.model.response.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
public class UsersController {

    @Autowired
    UserService userService;

    @PostMapping
    public UserRest createUser(@RequestBody UserRequestModel userDetails)
    {
        UserRest returnValue = new UserRest();

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);

        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser, returnValue);

        return returnValue;
    }
}
