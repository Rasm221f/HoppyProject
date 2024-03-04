package org.example.repository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.dto.UserInfoHobbyCountDTO;
import org.example.implementation.GenericDAOImpl;
import org.example.model.UserInfo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
public class UserInfoDAO extends GenericDAOImpl<UserInfo, Long> {

    @PersistenceContext
    private EntityManager entityManager;

    public UserInfo findUserInfoById(Long id) {
        return entityManager.find(UserInfo.class, id);
    }

    public List<UserInfo> findAllUserInfo() {
        TypedQuery<UserInfo> query = entityManager.createQuery(
                "SELECT ui FROM user_info ui JOIN FETCH ui.user JOIN FETCH ui.address JOIN FETCH ui.hobbies", UserInfo.class);
        return query.getResultList();
    }

    // Method to get a person with hobbies and address by user ID
    public UserInfo findDetailedUserInfoByUserId(int userId) {
        TypedQuery<UserInfo> query = entityManager.createQuery(
                "SELECT ui FROM user_info ui JOIN FETCH ui.user u WHERE u.id = :userId", UserInfo.class);
        query.setParameter("userId", userId);
        return query.getSingleResult();
    }

    public List<String> findPhoneNumbersByUserId(Long userId) {
        UserInfo userInfo = entityManager.find(UserInfo.class, userId);
        if (userInfo != null) {
            return userInfo.getPhoneNumbers();
        } else {
            return Collections.emptyList(); // Return an empty list if the user is not found
        }
    }
    public UserInfo findUserInfoByPhoneNumber(String phoneNumber) {
        TypedQuery<UserInfo> query = entityManager.createQuery(
                "SELECT ui FROM user_info ui JOIN ui.phoneNumbers p WHERE p = :phoneNumber", UserInfo.class);
        query.setParameter("phoneNumber", phoneNumber);
        return query.getSingleResult();
    }
    public List<UserInfo> findByLastName(String lastName) {
        return entityManager.createQuery(
                        "SELECT ui FROM user_info ui WHERE ui.lastName = :lastName", UserInfo.class)
                .setParameter("lastName", lastName)
                .getResultList();
    }
    public List<UserInfoHobbyCountDTO> findUsersWithHobbyCountsByAddress(Long addressId) {
        List<UserInfo> users = entityManager.createQuery(
                        "SELECT ui FROM user_info ui WHERE ui.address.id = :addressId", UserInfo.class)
                .setParameter("addressId", addressId)
                .getResultList();

        return users.stream()
                .map(ui -> new UserInfoHobbyCountDTO(
                        (long) ui.getUserInfoId(),
                        ui.getFirstName(),
                        ui.getLastName(),
                        ui.getHobbies().size()))
                .collect(Collectors.toList());
    }
}



