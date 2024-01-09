package com.alesyagit.demospringbootapp.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id//Id is a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String first_name;

    private String last_name;

    @NaturalId(mutable = true)//this annotation says us that this email is UNIQUE
                              //if we have TRUE it means that student(user) can modify its email
    private String email;

    private String department;
}
