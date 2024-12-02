package fundMe.data.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AdminTest {
    Admin admin;
    @BeforeEach
    void setUp() {
        admin = new Admin();
    }

    @Test
    public void test_thatAdminExists(){
        admin.setUsername("BimBim");
        admin.setPassword("password");
    }

}