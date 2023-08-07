package com.mycompany.propertymanagement.Service.Impl;

import com.mycompany.propertymanagement.Converter.UserConverter;
import com.mycompany.propertymanagement.Entity.UserEntity;
import com.mycompany.propertymanagement.Exception.BusinessException;
import com.mycompany.propertymanagement.Exception.ErrorModel;
import com.mycompany.propertymanagement.Repository.UserRepository;
import com.mycompany.propertymanagement.Service.UserService;
import com.mycompany.propertymanagement.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDto register(UserDto userDto) {
        Optional<UserEntity> optUe = userRepository.findByOwnerEmail(userDto.getOwnerEmail());
        if (optUe.isPresent()) {
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("EMAIL_ALREADY_EXISTS");
            errorModel.setMessage("The email which you are used to register already exists");
            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);
        }

        UserEntity userEntity = userConverter.convertDtotoEntity(userDto);
        userEntity = userRepository.save(userEntity);
        userDto = userConverter.convertEntitytoDto(userEntity);
        return userDto;
    }

    @Override
    public UserDto login(String email, String password) {
        UserDto userDto = null;
        Optional<UserEntity> optionalUserEntity = userRepository.findByOwnerEmailAndPassword(email, password);
        if (optionalUserEntity.isPresent()) {
            userDto = userConverter.convertEntitytoDto(optionalUserEntity.get());
        } else {
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("INVALID_CREDENTIALS");
            errorModel.setMessage("Email or Password is incorrect");
            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);
        }
        return userDto;

    }
}
