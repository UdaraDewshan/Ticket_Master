package edu.icet.model.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String userId;
    private String name;
    private String email;
    private String tier;
}