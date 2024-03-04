package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

import org.example.implementation.GenericDAOImpl;
import org.example.model.UserInfo;
import org.example.model.Zipcode;

public class ZipcodeDAO extends GenericDAOImpl<Zipcode, Long> {

    @PersistenceContext
    private EntityManager entityManager;

    public List<UserInfo> findUsersByCityName(String cityName) {
        TypedQuery<UserInfo> query = entityManager.createQuery(
                "SELECT ui FROM user_info ui " +
                        "JOIN ui.address a " +
                        "JOIN a.zipcode z " +
                        "WHERE z.cityName = :cityName", UserInfo.class);
        query.setParameter("cityName", cityName);
        return query.getResultList();
    }

    public List<Zipcode> findAllZipcodes() {
        return findAll();
    }
}
