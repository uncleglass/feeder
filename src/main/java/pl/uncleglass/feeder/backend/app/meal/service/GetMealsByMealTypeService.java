package pl.uncleglass.feeder.backend.app.meal.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.uncleglass.feeder.backend.app.meal.domain.Meal;
import pl.uncleglass.feeder.backend.app.meal.domain.MealType;
import pl.uncleglass.feeder.backend.app.meal.port.in.GetMealsByMealTypeUseCase;
import pl.uncleglass.feeder.backend.app.meal.port.out.LoadMealsByMealTypePort;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetMealsByMealTypeService implements GetMealsByMealTypeUseCase {
    private final LoadMealsByMealTypePort loadMealsByMealTypePort;

    @Override
    public List<Meal> getMealsByMealType(MealType mealType) {
        return loadMealsByMealTypePort.leadMealsByMealType(mealType);
    }
}
