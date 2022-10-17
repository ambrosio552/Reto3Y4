package co.usa.Reto3.Reto3.service;


import co.usa.Reto3.Reto3.model.Category;
import co.usa.Reto3.Reto3.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.getAll();
    }
    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }

    public Category save(Category p) {
        if (p.getId() == null) {
            return categoryRepository.save(p);
        } else {
            Optional<Category> cataux = categoryRepository.getCategory(p.getId());
            if (cataux.isEmpty()) {
                return categoryRepository.save(p);
            } else {
                return p;
            }
        }
    }

    public Category update(Category category) {
        if (category.getId() !=null) {
            Optional<Category>g= categoryRepository.getCategory(category.getId());
            if (!g.isEmpty()){
                if(category.getName()!= null){
                    g.get().setName(category.getName());
                }
                if(category.getDescription() !=null){
                    g.get().setDescription((category.getDescription()));
                }
                return categoryRepository.save(g.get());
            }
        }
        return category;
    }


    public boolean deleteCategory(int id){
        boolean d = getCategory(id).map(category -> {
            categoryRepository.delete(category);
            return true;
        }).orElse(false);
        return d;
    }

}
