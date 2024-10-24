package com.github.anothermarco.progresspuls.service.mapper;

import com.github.anothermarco.progresspuls.model.Role;
import com.github.anothermarco.progresspuls.model.User;
import com.github.anothermarco.progresspuls.rest.dto.UserCreateRequest;
import com.github.anothermarco.progresspuls.rest.dto.UserCreatedResponse;
import com.github.anothermarco.progresspuls.rest.dto.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = SPRING)
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", source = "role")
    User toEntity(UserCreateRequest userCreateRequest, Role role);

    UserCreatedResponse toCreatedResponse(User user);

    UserResponse toResponse(User user);

//    @BeanMapping(
//            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    User partialUpdate(UserCreateRequest userCreateRequest, @MappingTarget User user);
}