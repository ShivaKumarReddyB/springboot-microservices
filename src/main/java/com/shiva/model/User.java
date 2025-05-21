package com.shiva.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
//@Entity // create a table using the below class file with class name
@Entity(name ="user_table") // we can give custom table name
@RequiredArgsConstructor
public class User {
    @Id // setting the primary Key®
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private UserRole role = UserRole.CUSTOMER;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true) // one user can have one address
    @JoinColumn(name = "address_id", referencedColumnName = "id") // foreign key
    private Address address; // one to one mapping with address table

    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private  LocalDateTime updatedAt;

}
