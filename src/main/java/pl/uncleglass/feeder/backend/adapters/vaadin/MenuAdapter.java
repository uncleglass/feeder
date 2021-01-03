package pl.uncleglass.feeder.backend.adapters.vaadin;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenuAdapter {
    private List<DayMenuDto> menus;

    public MenuAdapter() {
        this.menus = getMenus();
    }

    public DayMenuDto getMenu() {
        return menus.get(0);
    }

    private List<DayMenuDto> getMenus() {
        List<DayMenuDto> menus = new ArrayList<>();
        DayMenuDto dayMenuDto = new DayMenuDto();
        dayMenuDto.setDate(LocalDate.now());
        dayMenuDto.setMeals(getMeals());
        menus.add(dayMenuDto);
        return menus;
    }

    private Map<String, MealDto> getMeals() {
        Map<String, MealDto> map = new HashMap<>();
        map.put("Śniadanie", getMealDto("Naleśniki"));
        map.put("Drugie śniadanie", getMealDto("Kanapki"));
        map.put("Obiad", getMealDto("Kotlety"));
        map.put("Podwieczorek", getMealDto("Pieczone jabłko"));
        map.put("Kolacja", getMealDto("Sałatka"));
        return map;
    }

    private MealDto getMealDto(String name) {
        MealDto meal = new MealDto();
        meal.setName(name);
        return meal;
    }
}
