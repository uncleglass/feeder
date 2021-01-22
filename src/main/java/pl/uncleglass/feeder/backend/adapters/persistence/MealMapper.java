package pl.uncleglass.feeder.backend.adapters.persistence;

import org.springframework.stereotype.Component;
import pl.uncleglass.feeder.backend.app.meal.domain.Meal;

import java.util.List;
import java.util.stream.Collectors;

@Component
class MealMapper {

    MealJpaEntity mapToJpaEntity(Meal meal) {
        if (meal == null) {
            return null;
        }
        MealJpaEntity jpaEntity = new MealJpaEntity();
        jpaEntity.setName(meal.getName());
        jpaEntity.setDescription(meal.getDescription());
        jpaEntity.setNotes(meal.getNotes());
        jpaEntity.setCalories(meal.getCalories());
        jpaEntity.setMealTypes(meal.getMealTypes());

        return jpaEntity;
    }

    Meal mapToDomainEntity(MealJpaEntity meal) {
        if (meal == null) {
            return null;
        }
        return new Meal(
                meal.getId(),
                meal.getName(),
                meal.getDescription(),
                meal.getNotes(),
                meal.getCalories(),
                meal.getMealTypes()
        );
    }

    List<Meal> mapToDomainEntityList(List<MealJpaEntity> meals) {
        return meals.stream()
                .map(this::mapToDomainEntity)
                .collect(Collectors.toList());
    }
}
