package org.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;

    private String streetName;
    private String streetNumber;

    @ManyToOne
    @JoinColumn(name = "zip")
    private Zipcode zipcode;

    @OneToMany(mappedBy = "address")
    private List<UserInfo> userInfos;
}
