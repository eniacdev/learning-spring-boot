package com.example.cont.demo.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Audited;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name = "test")
@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String lastname;
    private String password;
    private LocalDateTime createdTime;

}
