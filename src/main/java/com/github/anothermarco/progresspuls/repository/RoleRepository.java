package com.github.anothermarco.progresspuls.repository;

import com.github.anothermarco.progresspuls.model.Role;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface RoleRepository extends ListPagingAndSortingRepository<Role, Long>, ListCrudRepository<Role, Long> {
}
