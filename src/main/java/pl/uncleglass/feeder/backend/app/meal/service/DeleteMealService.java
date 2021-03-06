package pl.uncleglass.feeder.backend.app.meal.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.uncleglass.feeder.backend.app.meal.domain.Meal;
import pl.uncleglass.feeder.backend.app.meal.port.in.DeleteMealUseCase;
import pl.uncleglass.feeder.backend.app.meal.port.out.DeleteMealPort;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class DeleteMealService implements DeleteMealUseCase {
    private final DeleteMealPort deleteMealPort;

    @Override
    public void deleteMeal(Meal meal) {
        deleteMealPort.deleteMeal(meal);
    }
}
