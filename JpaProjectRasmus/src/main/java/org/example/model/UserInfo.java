package org.example.model;

import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity(name = "user_info")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userInfoId;

    private String firstName;
    private String lastName;
    private String email;

    @ElementCollection(fetch = FetchType.LAZY)
    private List<String> phoneNumbers; // Assuming phone numbers are stored as strings

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "zip")
    private Address address;


    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(
            name = "user_info_hobby",
            joinColumns = @JoinColumn(name = "userInfoId"),
            inverseJoinColumns = @JoinColumn(name = "hobbyId")
    )
    private List<Hobby> hobbies;
}

