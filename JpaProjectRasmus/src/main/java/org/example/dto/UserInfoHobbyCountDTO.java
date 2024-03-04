package org.example.dto;

import lombok.Value;

@Value
public class UserInfoHobbyCountDTO {
    Long username;
    String firstName;
    String lastName;
    int hobbyCount;
}
