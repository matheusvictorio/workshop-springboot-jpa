package com.praticando.courseSpring.repositories;

import com.praticando.courseSpring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
