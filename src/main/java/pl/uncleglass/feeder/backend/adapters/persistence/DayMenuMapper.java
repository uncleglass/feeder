package pl.uncleglass.feeder.backend.adapters.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.uncleglass.feeder.backend.app.meal.domain.Meal;
import pl.uncleglass.feeder.backend.app.meal.domain.MealType;
import pl.uncleglass.feeder.backend.app.menu.domain.DayMenu;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
class DayMenuMapper {
    private final MealMapper mealMapper;

    DayMenuJpaEntity mapToJpaEntity(DayMenu dayMenu) {
        return new DayMenuJpaEntity(
                dayMenu.getId(),
                dayMenu.getDate(),
                mapToJpaMeals(dayMenu.getMeals())
        );
    }

    private Map<MealType, MealJpaEntity> mapToJpaMeals(Map<MealType, Meal> meals) {
        Map<MealType, MealJpaEntity> jpaMeals = new HashMap<>();
        meals.forEach((key, value) -> jpaMeals.put(key, mealMapper.mapToJpaEntity(value)));//todo NPE dla value
        return jpaMeals;
    }

    public DayMenu mapToDomainEntity(DayMenuJpaEntity dayMenuJpaEntity) {
        if (dayMenuJpaEntity == null) {
            return null;
        }
        return new DayMenu(
                dayMenuJpaEntity.getId(),
                dayMenuJpaEntity.getDate(),
                mapToDomainMeals(dayMenuJpaEntity.getMeals())
        );
    }

    private Map<MealType, Meal> mapToDomainMeals(Map<MealType, MealJpaEntity> jpaMeals) {
        Map<MealType, Meal> meals = new HashMap<>();
        jpaMeals.forEach((key, value) -> meals.put(key, mealMapper.mapToDomainEntity(value)));
        return meals;
    }
}
