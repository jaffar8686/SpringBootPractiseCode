package com.example.springbootdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "user")
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "name cannot be empty")
    @Column(name = "name" )
    private String name;

    @Email(message = "invalid email Id")
    @Column(name = "email_id")
    private String emailId;

    @NotNull(message = "password cannot be empty")
    @Column(name = "password")
    private String password;

    @NotBlank(message = "country cannot be empty")
    @Column(name = "country")
    private String country;


    @Pattern(regexp = "^\\d{10}$",message = "invalid number")
    private String phoneNumber;

}
