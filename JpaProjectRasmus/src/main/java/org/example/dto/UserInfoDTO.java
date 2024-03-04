package org.example.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.Value;
import org.example.model.UserInfo;
import org.example.model.Hobby;

@Value
public class UserInfoDTO {

      String username;
      String firstName;
      String lastName;
      String email;
      List<String> phoneNumbers;
      String streetName;
      String streetNumber;
      String cityName;
      String regionName;
      String municipalityName;
      List<String> hobbies;

    public UserInfoDTO(UserInfo userInfo) {
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