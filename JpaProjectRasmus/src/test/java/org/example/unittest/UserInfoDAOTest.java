package org.example.unittest;
import org.example.model.UserInfo;
import org.example.model.Zipcode;
import org.example.repository.UserInfoDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.model.Address;
import org.example.model.Hobby;
import org.example.dto.UserInfoHobbyCountDTO;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserInfoDAOTest {

    private EntityManagerFactory emf;
    private EntityManager em;
    private UserInfoDAO userInfoDAO;
    private UserInfo userInfo;
    private Zipcode zipcode;

    @BeforeEach
    void setUp() {
        emf = Persistence.createEntityManagerFactory("testPU");
        em = emf.createEntityManager();
        userInfoDAO = new UserInfoDAO();
    }

    @Test
    void testFindUserInfoByPhoneNumber() {
        em.getTransaction().begin();
        UserInfo user = new UserInfo();
        em.persist(user);
        em.getTransaction().commit();

        assertNotNull(userInfoDAO.findUserInfoByPhoneNumber("+4521575525"));
    }
    @Test
    void testFindUsersWithHobbyCountsByAddress() {
        em.getTransaction().begin();
        Address address = new Address(7, "Sortemosevej", "19", zipcode, (List<UserInfo>) userInfo); // Set properties accordingly
        em.persist(address);

        UserInfo user = new UserInfo(); // Set properties accordingly
        user.setAddress(address);

        Hobby hobby = new Hobby(); // Set properties accordingly
        user.getHobbies().add(hobby);
        em.persist(hobby);
        em.persist(user);
        em.getTransaction().commit();

        List<UserInfoHobbyCountDTO> result = userInfoDAO.findUsersWithHobbyCountsByAddress((long) address.getAddressId());

        assertFalse(result.isEmpty(), "The result should not be empty.");
        assertTrue(result.stream().anyMatch(dto -> dto.getHobbyCount() > 0), "There should be a user with at least one hobby.");
    }
}

