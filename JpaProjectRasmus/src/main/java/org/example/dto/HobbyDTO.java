package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.model.UserInfo;
import org.example.repository.HobbyDAO;



import lombok.Value;

    @Value // This includes @Getter, @AllArgsConstructor, @EqualsAndHashCode, and @ToString
    public class HobbyDTO {
        String hobbyName;
        Long userCount;

        public void printHobbyInfo() {
            System.out.println("Hobby: " + hobbyName + ", Interested Users: " + userCount);
        }
    }

