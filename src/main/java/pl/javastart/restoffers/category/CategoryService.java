package pl.javastart.restoffers.category;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import pl.javastart.restoffers.offer.OfferRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;


    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDto> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(this::mapToDtoWithOffersSize)
                .collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        try {
            categoryRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ignore) {
            throw new IllegalArgumentException("Category with given id doesn't exist, try again!");
        }
    }

    private CategoryDto toDto(Category category) {
        CategoryDto dto = new CategoryDto();
        dto.setId(category.getId());
        dto.setName(category.getName());
        return dto;
    }

    private CategoryDto mapToDtoWithOffersSize(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        categoryDto.setDescription(category.getDescription());
        categoryDto.setOffersValue(category.getOffers().size());
        return categoryDto;
    }
}