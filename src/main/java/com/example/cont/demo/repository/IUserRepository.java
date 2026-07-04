package com.example.cont.demo.repository;

import com.example.cont.demo.dto.UserResponse;
import com.example.cont.demo.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

    List<User> findByName(String name);
    List<User> findByIdGreaterThan(Integer id);
    List<User> findAllByOrderByName();

}
