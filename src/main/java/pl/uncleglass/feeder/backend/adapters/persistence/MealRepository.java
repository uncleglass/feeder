package pl.uncleglass.feeder.backend.adapters.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.uncleglass.feeder.backend.app.meal.domain.MealType;

import java.util.List;
import java.util.UUID;

@Repository
interface MealRepository extends JpaRepository<MealJpaEntity, UUID> {
    List<MealJpaEntity> findAllByMealTypes(MealType mealType);
}
