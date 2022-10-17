package co.usa.Reto3.Reto3.repository.crud;

import co.usa.Reto3.Reto3.model.Ortopedic;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrtopedicCrudRepository extends CrudRepository<Ortopedic,Integer> {

   /* @Query("SELECT c.brand, COUNT(c.brand) FROM Ortopedic as c group by c.brand order by count(c.brand) desc")
    public List<Object[]> CountTotalOrtopedicByBrand();
    */
}


