package com.example.cont.demo.repository;

import com.example.cont.demo.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

    //JPA
    List<User> findByUserName(String name);
    List<User> findByUserIdGreaterThan(Integer id);
    List<User> findAllByOrderByUserName();

    // JPQL
    @Query("select u from User u")
    List<User> findAllUser();

    @Query("select u.userName from User u")
    List<String> findAllUserName();

}
