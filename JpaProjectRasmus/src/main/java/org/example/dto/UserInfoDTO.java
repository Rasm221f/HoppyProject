package org.example.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.model.UserInfo;
import org.example.model.Hobby;

@Getter
@Setter
@ToString
public class UserInfoDTO {

    private final int userId;
    private final String username;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final List<String> phoneNumbers;
    private final String streetName;
    private final String streetNumber;
    private final String cityName;
    private final String regionName;
    private final String municipalityName;
    private final List<String> hobbies;

    public UserInfoDTO(UserInfo userInfo) {
        this.userId = userInfo.getUser().getUserId();
        this.username = userInfo.getUser().getUsername();
        this.firstName = userInfo.getFirstName();
        this.lastName = userInfo.getLastName();
        this.email = userInfo.getEmail();
        this.phoneNumbers = new ArrayList<>(userInfo.getPhoneNumbers());
        this.streetName = userInfo.getAddress() != null ? userInfo.getAddress().getStreetName() : null;
        this.streetNumber = userInfo.getAddress() != null ? userInfo.getAddress().getStreetNumber() : null;
        this.cityName = userInfo.getAddress() != null && userInfo.getAddress().getZipcode() != null ? userInfo.getAddress().getZipcode().getCityName() : null;
        this.regionName = userInfo.getAddress() != null && userInfo.getAddress().getZipcode() != null ? userInfo.getAddress().getZipcode().getRegionName() : null;
        this.municipalityName = userInfo.getAddress() != null && userInfo.getAddress().getZipcode() != null ? userInfo.getAddress().getZipcode().getMunicipalityName() : null;
        this.hobbies = userInfo.getHobbies() != null ? userInfo.getHobbies().stream().map(Hobby::getName).collect(Collectors.toList()) : Collections.emptyList();
    }
}