package org.example.repository;
import org.example.model.UserInfo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.Collections;
import java.util.List;



public class PersonRepository {

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
}



