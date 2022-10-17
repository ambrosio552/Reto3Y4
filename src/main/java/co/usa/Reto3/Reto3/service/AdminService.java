package co.usa.Reto3.Reto3.service;

import co.usa.Reto3.Reto3.model.Admin;
import co.usa.Reto3.Reto3.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;
    public List<Admin>  getAll(){
        return adminRepository.getAll();
    }
    public Optional<Admin> getAdmin(int idAdmin){
        return adminRepository.getAdmin(idAdmin);
    }

    public Admin save(Admin p) {
        if (p.getIdAdmin() == null) {
            return adminRepository.save(p);
        } else {
            Optional<Admin> cataux = adminRepository.getAdmin(p.getIdAdmin());
            if (cataux.isEmpty()) {
                return adminRepository.save(p);
            } else {
                return p;
            }
        }

    }
    public Admin update(Admin admin) {
        if (admin.getIdAdmin() !=null) {
            Optional<Admin> j = adminRepository.getAdmin(admin.getIdAdmin());
            if (!j.isEmpty()) {
                if (admin.getEmail() != null) {
                    j.get().setName((admin.getName()));
                }
                if (admin.getPassword() != null) {
                    j.get().setPassword(admin.getPassword());
                }
                if (admin.getName() != null) {
                    j.get().setName(admin.getPassword());
                }
                adminRepository.save(j.get());
                return j.get();
            } else {
                return admin;
            }
        }else{
            return admin;
        }

    }
    public boolean deleteAdmin(int id){
        boolean d = getAdmin(id).map(admin -> {
             adminRepository.delete(admin);
            return true;
        }).orElse(false);
        return d;
    }

}

