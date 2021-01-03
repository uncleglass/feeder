package pl.uncleglass.feeder.backend.app.meal.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.uncleglass.feeder.backend.app.meal.domain.Meal;
import pl.uncleglass.feeder.backend.app.meal.port.in.AddMealUseCase;
import pl.uncleglass.feeder.backend.app.meal.port.out.AddMealPort;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AddMealService implements AddMealUseCase {
    private final AddMealPort addMealPort;

    @Override
    public void addMeal(Meal meal) {
        addMealPort.addMeal(meal);
    }
}
