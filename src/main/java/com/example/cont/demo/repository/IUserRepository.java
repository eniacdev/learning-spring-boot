package com.example.cont.demo.repository;

import com.example.cont.demo.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

    //JPA
    List<User> findByUserName(String name);
    List<User> findByUserIdGreaterThan(Integer id);
    List<User> findAllByOrderByUserName();

    // JPQL
    @Query("SELECT u FROM User u")
    List<User> findAllUser();

    @Query("SELECT u FROM User u WHERE u.userName IN :userNames")
    List<User> getUserNames(List<String> userNames);

    @Query("SELECT u FROM User u ORDER BY u.userId desc")
    List<User> getOrderById();

    @Query("SELECT u.userName FROM User u")
    List<String> findAllUserName();

    @Query("SELECT u.userName FROM User u WHERE u.userName = :userName")
    Optional<String> getUserName(@Param("userName") String userName);

    @Query("SELECT COUNT(u) FROM User u WHERE u.userId> :id")
    int findIdGreaterThan(Integer id);

    @Query("SELECT u FROM User u WHERE u.userId BETWEEN :minId AND :maxId")
    List<User> getMinAndMaxId(Integer minId, Integer maxId);

    @Query("SELECT u FROM User u WHERE u.userName LIKE CONCAT(:name, '%')")
    List<User> findByUserNameContaining(String name);

    //@Query("SELECT u FROM u WHERE u.userName = :userName AND u.password = :password")
    //Optional<User> userNameAndPassword(String userName, String password);



}
