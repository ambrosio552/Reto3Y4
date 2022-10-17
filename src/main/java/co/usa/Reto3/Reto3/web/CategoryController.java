package co.usa.Reto3.Reto3.web;


import co.usa.Reto3.Reto3.model.Category;
import co.usa.Reto3.Reto3.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*",methods = {
        RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT,RequestMethod.DELETE})


public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/all")
    public List<Category> getAll(){
        return categoryService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable("id") int Id){
        return categoryService.getCategory(Id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category p){
        return categoryService.save(p);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category update(@RequestBody Category category){
        return categoryService.update(category);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return categoryService.deleteCategory(id);
    }

}
