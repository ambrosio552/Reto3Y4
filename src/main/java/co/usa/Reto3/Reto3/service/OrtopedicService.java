package co.usa.Reto3.Reto3.service;

import co.usa.Reto3.Reto3.model.Ortopedic;
import co.usa.Reto3.Reto3.repository.OrtopedicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrtopedicService {

    @Autowired
    private OrtopedicRepository ortopedicRepository;

    public List<Ortopedic> getAll() {
        return ortopedicRepository.getAll();
    }
    public Optional<Ortopedic> getOrtopedic(int id){
        return ortopedicRepository.getOrtopedic(id);
    }

    public Ortopedic save(Ortopedic z){
        if(z.getId()==null){
            return ortopedicRepository.save(z);
        }else{
            Optional<Ortopedic> ortaux=ortopedicRepository.getOrtopedic(z.getId());
            if(ortaux.isEmpty()){
                return ortopedicRepository.save(z);
            }else {
                return z;
            }
        }

    }

    public Ortopedic update(Ortopedic ortopedic) {
        if (ortopedic.getId() !=null) {
            Optional<Ortopedic>r=ortopedicRepository.getOrtopedic(ortopedic.getId());
            if (!r.isEmpty()){
                if(ortopedic.getName() !=null){
                    r.get().setName((ortopedic.getName()));
                }
                if(ortopedic.getBrand()!= null){
                    r.get().setBrand(ortopedic.getBrand());
                }
                if(ortopedic.getYear()!=null){
                    r.get().setYear(ortopedic.getYear());
                }
                if(ortopedic.getDescription()!=null){
                    r.get().setDescription(ortopedic.getDescription());
                }
                ortopedicRepository.save(r.get());
                return r.get();
            }else {
                return ortopedic;
            }
        }else {
            return ortopedic;
        }
    }
    public boolean deleteOrtopedic(int id){
        boolean d = getOrtopedic(id).map(ortopedic -> {
            ortopedicRepository.delete(ortopedic);
            return true;
        }).orElse(false);
        return d;
    }
}
