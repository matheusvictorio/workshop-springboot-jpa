package com.praticando.courseSpring.repositories;

import com.praticando.courseSpring.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;


// Até poderia usar o @Repository, mas não é necessário pois ele herda da interface JpaRepository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
