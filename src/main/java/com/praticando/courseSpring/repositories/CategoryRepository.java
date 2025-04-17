package com.praticando.courseSpring.repositories;

import com.praticando.courseSpring.entities.Category;
import com.praticando.courseSpring.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;


// Até poderia usar o @Repository, mas não é necessário pois ele herda da interface JpaRepository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
