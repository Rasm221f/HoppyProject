package org.example.dto;

import java.util.List;
import java.util.stream.Collectors;
import org.example.model.UserInfo;
import org.example.model.Hobby;

public class UserInfoDTO {

    private int userId;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private List<String> phoneNumbers; // Updated to handle multiple phone numbers
    private String streetName;
    private String streetNumber;
    private String cityName;
    private String regionName;
    private String municipalityName;
    private List<String> hobbies;

    // Constructor
    public UserInfoDTO(UserInfo userInfo) {
        this.userId = userInfo.getUser().getUserId();
        this.username = userInfo.getUser().getUsername();
        this.firstName = userInfo.getFirstName();
        this.lastName = userInfo.getLastName();
        this.email = userInfo.getEmail();
        this.phoneNumbers = userInfo.getPhoneNumbers(); // Directly assigning the list
        if (userInfo.getAddress() != null) {
            this.streetName = userInfo.getAddress().getStreetName();
            this.streetNumber = userInfo.getAddress().getStreetNumber();
            if (userInfo.getAddress().getZipcode() != null) {
                this.cityName = userInfo.getAddress().getZipcode().getCityName();
                this.regionName = userInfo.getAddress().getZipcode().getRegionName();
                this.municipalityName = userInfo.getAddress().getZipcode().getMunicipalityName();
            }
        }
        this.hobbies = userInfo.getHobbies().stream().map(Hobby::getName).collect(Collectors.toList());
    }


    @Override
    public String toString() {
        return "UserInfoDTO{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumbers='" + phoneNumbers + '\'' +
                ", streetName='" + streetName + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", cityName='" + cityName + '\'' +
                ", regionName='" + regionName + '\'' +
                ", municipalityName='" + municipalityName + '\'' +
                ", hobbies=" + hobbies +
                '}';
    }
}