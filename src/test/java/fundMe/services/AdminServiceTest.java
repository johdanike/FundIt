package fundMe.services;

import fundMe.data.models.Admin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AdminServiceTest {
        Admin admin;
        @BeforeEach
        void setUp() {
            admin = new Admin();
        }

        @Test
        public void test_thatAdminExists(){
            admin.setUsername("BimBim");
            admin.setPassword("password");
            assertEquals("BimBim", admin.getUsername());
            assertEquals("password", admin.getPassword());
        }

}