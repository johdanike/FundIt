package fundMe.data.repositories;

import fundMe.data.models.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepoImpl extends MongoRepository<Admin, String> {

    Admin findByUsername(String username);
//    void deleteByUsername(String username);
//    void deleteByEmail(String email);
//    void deleteByUsernameAndPassword(String username, String password);
//    AdminRepo findByUsernameAndPassword(String username, String password);
//    AdminRepo findByEmail(String email);
//    String findbyId(String id);
}
