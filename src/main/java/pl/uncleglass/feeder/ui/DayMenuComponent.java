package pl.uncleglass.feeder.ui;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import pl.uncleglass.feeder.backend.adapters.vaadin.DayMenuDto;
import pl.uncleglass.feeder.backend.adapters.vaadin.MealDto;

import java.util.Map;

public class DayMenuComponent extends Composite<Div> {
    private Label date = new Label();
    private Map<String, MealDto> meals;
    private Button editMealsButton = new Button("Edytuj");

    public DayMenuComponent(DayMenuDto dayMenuDto) {
        date.setText(dayMenuDto.getDate().toString());

        meals = dayMenuDto.getMeals();

        configureEditMealsButton();
        getContent().add(
                date,
                configureMealsDisplaying(),
                editMealsButton);
    }

    private Component configureMealsDisplaying() {
        VerticalLayout layout = new VerticalLayout();

        HorizontalLayout breakfast = new HorizontalLayout();
        breakfast.add(new Label("Ś"));
        TextField breakfastName = new TextField();
        breakfastName.setReadOnly(true);
        MealDto breakfastValue = meals.get("Śniadanie");
        breakfastName.setValue(breakfastValue == null ? "" : breakfastValue.getName());
        breakfast.add(breakfastName);

        HorizontalLayout branch = new HorizontalLayout();
        branch.add(new Label("D"));
        TextField branchName = new TextField();
        branchName.setReadOnly(true);
        MealDto branchValue = meals.get("Drugie śniadanie");
        branchName.setValue(branchValue == null ? "" : branchValue.getName());
        branch.add(branchName);

        HorizontalLayout lunch = new HorizontalLayout();
        lunch.add(new Label("O"));
        TextField lunchName = new TextField();
        lunchName.setReadOnly(true);
        MealDto lunchValue = meals.get("Obiad");
        lunchName.setValue(lunchValue == null ? "" : lunchValue.getName());
        lunch.add(lunchName);

        HorizontalLayout snack = new HorizontalLayout();
        snack.add(new Label("P"));
        TextField snackName = new TextField();
        snackName.setReadOnly(true);
        MealDto snackValue = meals.get("Przekąska");
        snackName.setValue(snackValue == null ? "" : snackValue.getName());
        snack.add(snackName);

        HorizontalLayout supper = new HorizontalLayout();
        supper.add(new Label("K"));
        TextField supperName = new TextField();
        supperName.setReadOnly(true);
        MealDto supperValue = meals.get("Kolacja");
        supperName.setValue(supperValue == null ? "" : supperValue.getName());
        supper.add(supperName);

        layout.add(breakfast, branch, lunch, snack, supper);

        return layout;
    }

    private void configureEditMealsButton() {

    }
}
