package com.example.cont.demo.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Audited;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name = "test")
@Entity
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String lastname;
    private String password;

}
