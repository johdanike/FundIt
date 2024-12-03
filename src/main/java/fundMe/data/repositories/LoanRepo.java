package fundMe.data.repositories;

import fundMe.data.models.Loan;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepo extends MongoRepository<Loan, String> {
}
