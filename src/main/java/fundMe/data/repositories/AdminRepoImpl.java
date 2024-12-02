package fundMe.data.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdminRepoImpl extends MongoRepository<Admin, String> {
    Admin findByUsername(String username);
    void deleteByUsername(String username);


}
