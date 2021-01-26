package pl.uncleglass.feeder.backend.app.menu.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.uncleglass.feeder.backend.app.meal.domain.Meal;
import pl.uncleglass.feeder.backend.app.meal.domain.MealType;
import pl.uncleglass.feeder.backend.app.meal.port.out.LoadMealPort;
import pl.uncleglass.feeder.backend.app.menu.domain.DayMenu;
import pl.uncleglass.feeder.backend.app.menu.port.in.AddMealToDayMenuUseCase;
import pl.uncleglass.feeder.backend.app.menu.port.out.LoadDayMenuPort;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AddMealToDayMenuService implements AddMealToDayMenuUseCase {
    private final LoadDayMenuPort loadDayMenuPort;
    private final LoadMealPort loadMealPort;

    @Override
    @Transactional
    public void addMealToDayMenu(AddMealToDayMenuCommand command) {
        UUID dayMenuId = command.getDayMenuId();
        DayMenu dayMenu = loadDayMenuPort.loadDayMenu(dayMenuId);

        UUID mealId = command.getMealId();
        Meal meal = loadMealPort.loadMeal(mealId);

        MealType mealType = command.getMealType();

        dayMenu.addMeal(mealType, meal);
    }
}
