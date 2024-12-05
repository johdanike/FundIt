package fundMe.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoanServiceImplTest {
    LoanServiceImpl loanService;

    @BeforeEach
    public void setUp() {
        loanService = new LoanServiceImpl();
    }


}