package vn.edu.uit.lms_se347.dto;

import lombok.Data;
@Data
public class LoginRequest {
    private String email;
    private String password;
}