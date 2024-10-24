package com.github.anothermarco.progresspuls.service.mapper;

import com.github.anothermarco.progresspuls.model.User;
import com.github.anothermarco.progresspuls.rest.dto.UserCreateRequest;
import com.github.anothermarco.progresspuls.rest.dto.UserCreatedResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = SPRING)
public interface UserMapper {
    User toEntity(UserCreateRequest userCreateRequest);

    UserCreatedResponse toDto(User user);

//    @BeanMapping(
//            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    User partialUpdate(UserCreateRequest userCreateRequest, @MappingTarget User user);
}