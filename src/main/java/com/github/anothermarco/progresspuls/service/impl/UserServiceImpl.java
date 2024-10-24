package com.github.anothermarco.progresspuls.service.impl;

import com.github.anothermarco.progresspuls.exception.RoleNotFoundException;
import com.github.anothermarco.progresspuls.exception.UserNotFoundException;
import com.github.anothermarco.progresspuls.model.Role;
import com.github.anothermarco.progresspuls.model.User;
import com.github.anothermarco.progresspuls.repository.RoleRepository;
import com.github.anothermarco.progresspuls.repository.UserRepository;
import com.github.anothermarco.progresspuls.rest.dto.UserCreateRequest;
import com.github.anothermarco.progresspuls.rest.dto.UserCreatedResponse;
import com.github.anothermarco.progresspuls.rest.dto.UserResponse;
import com.github.anothermarco.progresspuls.service.UserService;
import com.github.anothermarco.progresspuls.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }

    @Override
    public UserCreatedResponse createUser(UserCreateRequest userCreateRequest) {
        long roleId = userCreateRequest.roleId();
        Role role = roleRepository.findById(roleId).orElseThrow(() -> new RoleNotFoundException(roleId));
        User entity = userMapper.toEntity(userCreateRequest, role);

        User saved = userRepository.save(entity);
        return userMapper.toCreatedResponse(saved);
    }

    @Override
    public UserResponse findById(long id) {
        return userRepository.findById(id)
                .map(userMapper::toResponse)
                .orElseThrow(() -> new UserNotFoundException(id));
    }


}
