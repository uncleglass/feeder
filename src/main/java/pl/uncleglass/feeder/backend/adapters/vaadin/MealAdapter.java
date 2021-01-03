package pl.uncleglass.feeder.backend.adapters.vaadin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.uncleglass.feeder.backend.app.meal.domain.MealType;
import pl.uncleglass.feeder.backend.app.meal.port.in.AddMealUseCase;
import pl.uncleglass.feeder.backend.app.meal.port.in.DeleteMealUseCase;
import pl.uncleglass.feeder.backend.app.meal.port.in.GetAllMealsUseCase;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MealAdapter {
    private final AddMealUseCase addMealUseCase;
    private final GetAllMealsUseCase getAllMealsUseCase;
    private final DeleteMealUseCase deleteMealUseCase;

    public List<MealDto> getAll() {
        return MealMapper.mapToMealDtoList(getAllMealsUseCase.getAllMeals());
    }

    public void delete(MealDto meal) {
        deleteMealUseCase.deleteMeal(MealMapper.mapToMeal(meal));
    }

    public void save(MealDto meal) {
        addMealUseCase.addMeal(MealMapper.mapToMeal(meal));
    }

    public static List<String> getMealTypes() {
                return Arrays.stream(MealType.values())
                .map(MealMapper::convertMealType)
                .collect(Collectors.toList());
    }
}
