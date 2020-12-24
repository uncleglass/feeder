package pl.uncleglass.feeder.adapters;

import org.springframework.stereotype.Service;
import pl.uncleglass.feeder.backend.meals.MealService;
import pl.uncleglass.feeder.backend.meals.MealType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MealAdapter {
    private final MealService mealService;

    public MealAdapter(MealService mealService) {
        this.mealService = mealService;
    }

    public List<MealDto> getAll() {
        return MealMapper.mapToMealDtoList(mealService.getAll());
    }

    public void delete(MealDto meal) {
        mealService.delete(MealMapper.mapToMeal(meal));
    }

    public void save(MealDto meal) {
        mealService.save(MealMapper.mapToMeal(meal));
    }

    public static List<String> getMealTypes() {
        return Arrays.stream(MealType.values())
                .map(MealMapper::convertMealType)
                .collect(Collectors.toList());
    }
}
