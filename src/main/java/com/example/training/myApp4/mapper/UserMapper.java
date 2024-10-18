package com.example.training.myApp4.mapper;

import com.example.training.myApp4.entity.User;
import com.example.training.myApp4.response.RegisterResponse;
import com.example.training.myApp4.response.UpdateUserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    RegisterResponse toRegisterResponse(User user);
    UpdateUserResponse toUpdateUserResponse(User user);
}
