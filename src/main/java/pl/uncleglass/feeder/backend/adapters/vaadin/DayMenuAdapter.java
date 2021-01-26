package pl.uncleglass.feeder.backend.adapters.vaadin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.uncleglass.feeder.backend.app.meal.domain.MealType;
import pl.uncleglass.feeder.backend.app.menu.port.in.AddMealToDayMenuUseCase;
import pl.uncleglass.feeder.backend.app.menu.port.in.GetDayMenuUseCase;

import java.time.LocalDate;
import java.util.UUID;

import static pl.uncleglass.feeder.backend.app.menu.port.in.AddMealToDayMenuUseCase.*;

@Service
@RequiredArgsConstructor
public class DayMenuAdapter {
    private final GetDayMenuUseCase getDayMenuUseCase;
    private final AddMealToDayMenuUseCase addMealToDayMenuUseCase;

    public DayMenuDto getDayMenu(LocalDate date) {
        return DayMenuMapper.mapToDto(getDayMenuUseCase.getDayMenu(date));
    }

    public DayMenuDto getDayMenu(UUID dayMenuId) {
        return DayMenuMapper.mapToDto(getDayMenuUseCase.getDayMenu(dayMenuId));
    }

    public void addMealToDayMenu(UUID dayMenuId, String mealTypeStr, UUID menuId) {
        MealType mealType = MealMapper.convertMealTypeStr(mealTypeStr);
        addMealToDayMenuUseCase.addMealToDayMenu(
                new AddMealToDayMenuCommand(
                        dayMenuId,
                        mealType,
                        menuId
                )
        );
    }
}
