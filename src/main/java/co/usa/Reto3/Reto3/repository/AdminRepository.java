package co.usa.Reto3.Reto3.repository;


import co.usa.Reto3.Reto3.model.Admin;
import co.usa.Reto3.Reto3.repository.crud.AdminCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class AdminRepository {
    @Autowired
   private AdminCrudRepository adminCrudRepository;

    public List<Admin> getAll(){
        return (List<Admin>) adminCrudRepository.findAll();

    }
    public Optional<Admin> getAdmin(int IdAdmin){
        return adminCrudRepository.findById(IdAdmin);
    }
    public Admin save(Admin c){
        return adminCrudRepository.save(c);
    }

    public void delete(Admin admin){
        adminCrudRepository.delete(admin);
    }

}
