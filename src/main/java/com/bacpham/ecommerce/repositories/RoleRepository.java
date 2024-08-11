package com.bacpham.ecommerce.repositories;

import com.bacpham.ecommerce.model.AppRole;
import com.bacpham.ecommerce.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByRoleName(AppRole roleUser);
}
