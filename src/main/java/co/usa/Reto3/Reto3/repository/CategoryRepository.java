package co.usa.Reto3.Reto3.repository;


import co.usa.Reto3.Reto3.model.Category;
import co.usa.Reto3.Reto3.repository.crud.CategoryCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {
    @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    public List<Category> getAll(){
        return (List<Category>) categoryCrudRepository.findAll();

    }
    public Optional<Category>getCategory(int Id){

        return categoryCrudRepository.findById(Id);
    }
    public Category save(Category c){
        return categoryCrudRepository.save(c);
    }

    public void delete(Category category){

        categoryCrudRepository.delete(category);
    }

}
