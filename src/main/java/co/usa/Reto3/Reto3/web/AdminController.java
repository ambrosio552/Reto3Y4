package co.usa.Reto3.Reto3.web;

import co.usa.Reto3.Reto3.model.Admin;
import co.usa.Reto3.Reto3.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Admin")
@CrossOrigin(origins = "*",methods = {
        RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})


public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/all")
    public List<Admin> getAll() {
        return adminService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Admin> getAdmin(@PathVariable("idAdmin") int IdAdmin) {
        return adminService.getAdmin(IdAdmin);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin save(@RequestBody Admin p) {
        return adminService.save(p);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin update(@RequestBody Admin admin) {
        return adminService.update(admin);
    }
    @DeleteMapping("/{idAdmin}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("idAdmin") int id){
        return adminService.deleteAdmin(id);
    }


}

