package pl.uncleglass.feeder.backend.adapters.persistence;

import org.springframework.stereotype.Component;
import pl.uncleglass.feeder.backend.app.meal.domain.Meal;

import java.util.List;
import java.util.stream.Collectors;

@Component
class MealMapper {

    MealJpaEntity mapToJpaEntity(Meal meal) {
        return new MealJpaEntity(
                meal.getId(),
                meal.getName(),
                meal.getDescription(),
                meal.getNotes(),
                meal.getCalories(),
                meal.getMealTypes()
        );
    }

    public Meal mapToDomainEntity(MealJpaEntity meal) {
        return new Meal(
                meal.getId(),
                meal.getName(),
                meal.getDescription(),
                meal.getNotes(),
                meal.getCalories(),
                meal.getMealTypes()
        );
    }

    public List<Meal> mapToDomainEntityList(List<MealJpaEntity> meals) {
        return meals.stream()
                .map(this::mapToDomainEntity)
                .collect(Collectors.toList());
    }
}
