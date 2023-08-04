package com.mycompany.propertymanagement.Service.Impl;

import com.mycompany.propertymanagement.Converter.UserConverter;
import com.mycompany.propertymanagement.Entity.UserEntity;
import com.mycompany.propertymanagement.Repository.UserRepository;
import com.mycompany.propertymanagement.Service.UserService;
import com.mycompany.propertymanagement.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository  userRepository;

    @Autowired
    private UserConverter userConverter;
    @Override
    public UserDto register(UserDto userDto) {
        UserEntity userEntity = userConverter.convertDtotoEntity(userDto);
        userEntity = userRepository.save(userEntity);
        userDto = userConverter.convertEntitytoDto(userEntity);
        return userDto;
    }

    @Override
    public UserDto login(String email, String password) {
        return null;
    }
}
