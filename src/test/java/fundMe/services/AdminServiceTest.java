package fundMe.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AdminServiceTest {
        Admin admin;
        @BeforeEach
        void setUp() {
            admin = new Admin();
        }

        @Test
        public void test_thatAdminCanBeCreated_adminExists(){
            admin.setUsername("BimBim");
            admin.setPassword("password");
            assertEquals("BimBim", admin.getUsername());
            assertEquals("password", admin.getPassword());
        }
        @Test
        public void test_thatAdminCanBeCreated_adminCanBeDeleted_adminDoesNotExist(){
            admin.setUsername("BimBim");
            admin.setPassword("password");
            assertEquals("BimBim", admin.getUsername());
            assertEquals("password", admin.getPassword());
            admin.delete("BimBim");
            assertFalse(admin.getUsername().equals("BimBim"));

        }

}