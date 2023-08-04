package com.mycompany.propertymanagement.Converter;

import com.mycompany.propertymanagement.Entity.UserEntity;
import com.mycompany.propertymanagement.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public UserEntity convertDtotoEntity(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setOwnerEmail(userDto.getOwnerEmail());
        userEntity.setOwnerName(userDto.getOwnerName());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setPhone(userDto.getPhone());
        return userEntity;

    }

    public UserDto convertEntitytoDto(UserEntity userEntity) {
        UserDto userDto = new UserDto();
        userDto.setId(userEntity.getId());
        userDto.setOwnerEmail(userEntity.getOwnerEmail());
        userDto.setOwnerName(userEntity.getOwnerName());
        userDto.setPhone(userEntity.getPhone());
        return userDto;
    }
}
