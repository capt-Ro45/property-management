package com.mycompany.propertymanagement.Service;

import com.mycompany.propertymanagement.dto.UserDto;

public interface UserService {

   UserDto register(UserDto userDto);
   UserDto login(String email, String password);

}
