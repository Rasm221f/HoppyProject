package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;

    private String streetName;
    private String streetNumber;

    @ManyToOne
    @JoinColumn(name = "areaId")
    private Zipcode zipcode;

    @OneToMany(mappedBy = "address")
    private List<UserInfo> userInfos;
}
