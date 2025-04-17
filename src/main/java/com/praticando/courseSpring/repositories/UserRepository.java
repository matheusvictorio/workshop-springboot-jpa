package com.praticando.courseSpring.repositories;

import com.praticando.courseSpring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


// Até poderia usar o @Repository, mas não é necessário pois ele herda da interface JpaRepository
public interface UserRepository extends JpaRepository<User, Long> {
}
