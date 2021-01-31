package pl.uncleglass.feeder.ui;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import pl.uncleglass.feeder.backend.adapters.vaadin.DayMenuAdapter;
import pl.uncleglass.feeder.backend.adapters.vaadin.DayMenuDto;
import pl.uncleglass.feeder.backend.adapters.vaadin.MealAdapter;
import pl.uncleglass.feeder.backend.adapters.vaadin.MealDto;

import java.util.UUID;

@Route(value = "edit-day-menu", layout = MainLayout.class)
public class EditDayMenuView extends VerticalLayout implements HasUrlParameter<String>, AfterNavigationObserver {
    Label date = new Label();
    private final DayMenuAdapter dayMenuAdapter;
    private final MealAdapter mealAdapter;
    private DayMenuDto dayMenuDto;
    ComboBox breakfast = new ComboBox();

    public EditDayMenuView(DayMenuAdapter dayMenuAdapter, MealAdapter mealAdapter) {
        this.dayMenuAdapter = dayMenuAdapter;
        this.mealAdapter = mealAdapter;

        configureBreakfast();
        add(date, breakfast);
    }

    private void configureBreakfast() {
        breakfast.setItems(mealAdapter.getMealsByMealType("Śniadanie"));
        breakfast.setItemLabelGenerator(item -> {
            MealDto mealDto = (MealDto) item;
            return mealDto.getName();
        });
        breakfast.addValueChangeListener( event -> {
            MealDto mealDto = (MealDto) event.getValue();
            dayMenuAdapter.addMealToDayMenu(
                    dayMenuDto.getId(),
                    "Śniadanie",
                    mealDto.getId()
            );
        });
    }

    @Override
    public void setParameter(BeforeEvent event, String parameter) {
        dayMenuDto = dayMenuAdapter.getDayMenu(UUID.fromString(parameter));
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        date.setText(dayMenuDto.getDate().toString());
    }
}
