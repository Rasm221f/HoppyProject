package org.example.unittest;

import org.example.model.Hobby;
import org.example.model.UserInfo;
import org.example.repository.HobbyDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HobbyDAOTest {

    private EntityManagerFactory emf;
    private EntityManager em;
    private HobbyDAO hobbyDAO;
    private UserInfo userInfo;

    @BeforeEach
    void setUp() {
        emf = Persistence.createEntityManagerFactory("testPU");
        em = emf.createEntityManager();
        hobbyDAO = new HobbyDAO();
        userInfo = new UserInfo();
    }

    @Test
    void testFindUsersByHobbyName() {
        em.getTransaction().begin();
        Hobby hobby = new Hobby(1,"3D-udskrivning","https://en.wikipedia.org/wiki/3D_printing","Generel","Indendørs", (List<UserInfo>) userInfo);
        UserInfo user = new UserInfo();
        user.getHobbies().add(hobby);
        em.persist(hobby);
        em.persist(user);
        em.getTransaction().commit();

        assertFalse(hobbyDAO.findUsersByHobbyName("3D-udskrivning").isEmpty());
    }


}
