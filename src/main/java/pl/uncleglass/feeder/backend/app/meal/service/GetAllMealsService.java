package pl.uncleglass.feeder.backend.app.meal.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.uncleglass.feeder.backend.app.meal.domain.Meal;
import pl.uncleglass.feeder.backend.app.meal.port.in.GetAllMealsUseCase;
import pl.uncleglass.feeder.backend.app.meal.port.out.LoadAllMealsPort;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllMealsService implements GetAllMealsUseCase {
    private final LoadAllMealsPort loadAllMealsPort;

    @Override
    public List<Meal> getAllMeals() {
        return loadAllMealsPort.loadAllMeals();
    }
}
