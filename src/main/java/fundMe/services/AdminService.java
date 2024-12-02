package fundMe.services;


import fundMe.data.models.Admin;
import fundMe.data.repositories.AdminRepoImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdminService implements AdminServiceImpl{
    private final AdminRepoImpl repo;

    public void e(){
        Admin a = repo.findByUsername("are");
    }
}
