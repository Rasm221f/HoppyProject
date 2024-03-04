package org.example.model;

import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table (name = "zipcode")
public class Zipcode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int zip;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "region_name")
    private String regionName;

    @Column(name = "municipality_name")
    private String municipalityName;

    @OneToMany(mappedBy = "zip", cascade = CascadeType.REMOVE)
    private List<Address> addresses;
}