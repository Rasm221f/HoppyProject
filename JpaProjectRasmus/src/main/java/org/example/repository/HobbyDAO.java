package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

import org.example.implementation.GenericDAOImpl;
import org.example.model.Hobby;
import org.example.model.UserInfo;

public class HobbyDAO extends GenericDAOImpl<UserInfo, Long> {

    @PersistenceContext
    private EntityManager entityManager;

    public List<UserInfo> findUsersByHobbyName(String hobbyName) {
        TypedQuery<UserInfo> query = entityManager.createQuery(
                "SELECT ui FROM user_info ui JOIN ui.hobbies h WHERE h.name = :hobbyName", UserInfo.class);
        query.setParameter("hobbyName", hobbyName);
        return query.getResultList();
    }
    public long countUsersByHobbyName(String hobbyName) {
        TypedQuery<Long> query = entityManager.createQuery(
                "SELECT COUNT(DISTINCT ui) FROM user_info ui JOIN ui.hobbies h WHERE h.name = :hobbyName", Long.class);
        query.setParameter("hobbyName", hobbyName);
        return query.getSingleResult();
    }
    public List<Object[]> findAllHobbiesWithCounts() {
        TypedQuery<Object[]> query = entityManager.createQuery(
                "SELECT h.name, COUNT(ui) FROM hobby h JOIN h.userInfos ui GROUP BY h.name", Object[].class);
        return query.getResultList();
    }
}

