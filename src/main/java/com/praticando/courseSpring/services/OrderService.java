package com.praticando.courseSpring.services;

import com.praticando.courseSpring.entities.Order;
import com.praticando.courseSpring.entities.User;
import com.praticando.courseSpring.repositories.OrderRepository;
import com.praticando.courseSpring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    public OrderRepository userRepository;

    public List<Order> findAll() {
       return userRepository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> order = userRepository.findById(id);
        return order.get();

    }
}
