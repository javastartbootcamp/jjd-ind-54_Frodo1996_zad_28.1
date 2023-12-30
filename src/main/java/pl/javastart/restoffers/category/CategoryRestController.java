package pl.javastart.restoffers.category;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/categories")
@RestController
public class CategoryRestController {

    private final CategoryService categoryService;

    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/names")
    public List<CategoryDto> findAll() {
        return categoryService.findAll();
    }

    @GetMapping
    public List<CategoryDto> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        categoryService.deleteById(id);
    }
}
