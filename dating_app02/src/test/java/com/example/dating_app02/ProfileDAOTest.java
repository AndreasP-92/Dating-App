package com.example.dating_app02;

import com.example.dating_app02.model.Profile;
import com.example.dating_app02.service.ProfileDAO;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ProfileDAOTest {
    private ProfileDAO dao;

    @Test
    void testlist() {
        List<Profile> listProfile = dao.list();

        System.out.println(listProfile);
    }
}
