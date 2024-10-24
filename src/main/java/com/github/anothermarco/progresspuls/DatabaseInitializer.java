package com.github.anothermarco.progresspuls;

import com.github.anothermarco.progresspuls.config.security.Permission;
import com.github.anothermarco.progresspuls.model.Role;
import com.github.anothermarco.progresspuls.model.User;
import com.github.anothermarco.progresspuls.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DatabaseInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public void run(String... args) {
        if (userRepository.findByEmail("admin@example.com").isEmpty()) {
            Role role = new Role();
            role.setName("ADMIN");
            Set<Permission> permissions = Arrays.stream(Permission.values()).collect(Collectors.toSet());
            role.setPermissions(permissions);

            User user = new User();
            user.setEmail("admin@example.com");
            user.setRole(role);
            user.setPassword(passwordEncoder.encode("admin"));
            user.setUsername("admin");

            userRepository.save(user);
        }
    }
}
