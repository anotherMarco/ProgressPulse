package com.github.anothermarco.progresspuls.service;

import com.github.anothermarco.progresspuls.model.User;
import com.github.anothermarco.progresspuls.repository.UserRepository;
import com.github.anothermarco.progresspuls.rest.dto.UserCreateRequest;
import com.github.anothermarco.progresspuls.rest.dto.UserCreatedResponse;
import com.github.anothermarco.progresspuls.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }

    public UserCreatedResponse createUser(UserCreateRequest userCreateRequest) {
        User entity = userMapper.toEntity(userCreateRequest);
        User saved = userRepository.save(entity);
        return userMapper.toDto(saved);
    }
}
