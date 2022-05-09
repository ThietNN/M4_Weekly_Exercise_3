package thietnn.m4_weekly_exercise_3.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import thietnn.m4_weekly_exercise_3.model.Category;

@Repository
public interface ICategoryRepository extends CrudRepository<Category,Long> {
}
