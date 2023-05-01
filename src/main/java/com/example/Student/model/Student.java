package com.example.Student.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentId;

    @NotBlank
    @Size(min = 2, max = 50)
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 50)
    private String lastName;

    @NotBlank
    @Size(min=5,max = 50)
    @Pattern(regexp ="^[a-zA-Z0-9_]")
    private String userName;

    @NotBlank
    private String rollNo;

    @NotNull
    @Past
    private LocalDate dob;

    @NotBlank
    private String address;

    @NotBlank
    private String city;

    @NotBlank
    @Pattern(regexp = "\\d{7}")
    private String zipCode;

    @Email
    @NotBlank
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    private String Email;

    @NotBlank
    @Pattern(regexp = "\\d{10}")
    private String phoneNumber;


    @Enumerated(EnumType.STRING)
    private Department department;

}
