package pl.uncleglass.feeder.backend.app.menu.port.in;

import lombok.Getter;
import pl.uncleglass.feeder.backend.app.meal.domain.MealType;

import java.util.UUID;

public interface AddMealToDayMenuUseCase {
    void addMealToDayMenu(AddMealToDayMenuCommand command);

    @Getter
    class AddMealToDayMenuCommand {
        private final UUID dayMenuId;
        private final MealType mealType;
        private final long mealId;

        public AddMealToDayMenuCommand(
                UUID dayMenuId,
                MealType mealType,
                long mealId) {
            this.dayMenuId = dayMenuId;
            this.mealType = mealType;
            this.mealId = mealId;
        }
    }
}
