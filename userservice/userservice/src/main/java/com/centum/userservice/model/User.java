package com.centum.userservice.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name="USER_TABLE")
@NoArgsConstructor
@AllArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @NotBlank
    @Size(max = 20)
    private String username;
    @NotBlank
    @Size(max = 15)
    private String password;
    @NotBlank
    @Email
    @Size(max = 64 )
    private String email;
    @NotBlank
    @Size(max=10)
    private String PhoneNumber;

}
