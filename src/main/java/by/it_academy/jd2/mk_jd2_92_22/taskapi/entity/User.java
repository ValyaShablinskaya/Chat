package by.it_academy.jd2.mk_jd2_92_22.taskapi.entity;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;
@Data
@Builder
public class User {
    //private int id;
    private String login;
    private String password;
    private String fullName;
    private LocalDate birthday;
    private LocalDate dateOfRegistration;
    private Role role;

}