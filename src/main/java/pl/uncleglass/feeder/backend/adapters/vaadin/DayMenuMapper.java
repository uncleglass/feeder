package pl.uncleglass.feeder.backend.adapters.vaadin;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.uncleglass.feeder.backend.app.meal.domain.Meal;
import pl.uncleglass.feeder.backend.app.meal.domain.MealType;
import pl.uncleglass.feeder.backend.app.menu.domain.DayMenu;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class DayMenuMapper {

    static DayMenuDto mapToDto(DayMenu dayMenu) {
        return new DayMenuDto(
                dayMenu.getId(),
                dayMenu.getDate(),
                mapToDtoMeals(dayMenu.getMeals())
        );
    }

    static private Map<String, MealDto> mapToDtoMeals(Map<MealType, Meal> meals) {
        Map<String, MealDto> mealsDto = new HashMap<>();
        meals.forEach((key, value) -> mealsDto.put(MealMapper.convertMealType(key), MealMapper.mapToMealDto(value)));
        return mealsDto;
    }
}
