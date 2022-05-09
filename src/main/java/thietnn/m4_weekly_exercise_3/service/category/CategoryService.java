package thietnn.m4_weekly_exercise_3.service.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thietnn.m4_weekly_exercise_3.model.Category;
import thietnn.m4_weekly_exercise_3.repository.ICategoryRepository;

import java.util.Optional;

@Service
public class CategoryService implements ICategoryService{
    @Autowired
    ICategoryRepository categoryRepository;

    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category save(Category category)  {
        return categoryRepository.save(category);
    }

    @Override
    public void removeById(Long id) {
        categoryRepository.deleteById(id);
    }
}
