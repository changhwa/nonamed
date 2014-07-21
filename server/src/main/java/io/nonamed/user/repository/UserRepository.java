package io.nonamed.user.repository;

import io.nonamed.user.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, String> {



}
