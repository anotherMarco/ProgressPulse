package com.github.anothermarco.progresspuls.repository;

import com.github.anothermarco.progresspuls.model.User;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface UserRepository extends ListPagingAndSortingRepository<User, Long>, ListCrudRepository<User, Long> {
    @NonNull
    Optional<User> findByEmail(@NonNull String email);
}