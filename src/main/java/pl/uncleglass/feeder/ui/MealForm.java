package pl.uncleglass.feeder.ui;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.shared.Registration;
import pl.uncleglass.feeder.adapters.MealAdapter;
import pl.uncleglass.feeder.adapters.MealDto;

public class MealForm extends FormLayout {
    TextField name = new TextField("Nazwa");
    TextArea description = new TextArea("Opis");
    TextArea notes = new TextArea("Uwagi");
    NumberField calories = new NumberField("Kalorie");
    CheckboxGroup<String> mealType = new CheckboxGroup<>();

    Button save = new Button("Zapisz");
    Button delete = new Button("Usuń");
    Button cancel = new Button("Anuluj");

    Binder<MealDto> binder = new Binder<>(MealDto.class);

    public MealForm() {
        addClassName("meal-form");

        calories.setValue(0d);
        calories.setHasControls(true);

        binder.forField(calories)
                .withConverter(Double::intValue, Integer::doubleValue )
                .bind(MealDto::getCalories, MealDto::setCalories);


        mealType.setItems(MealAdapter.getMealTypes());
        mealType.setLabel("Typ posiłku");

        mealType.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);


        binder.bindInstanceFields(this);
        binder.bind(mealType, "mealTypes");

        add(
                name,
                createSubLayout(),
                description,
                notes,
                createButtonsLayout()
        );
    }

    private Component createSubLayout() {
        HorizontalLayout layout = new HorizontalLayout();
        layout.add(mealType, calories);
        return layout;
    }

    public void setMeal(MealDto mealDto) {
        binder.setBean(mealDto);
    }

    private Component createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickShortcut(Key.ENTER);
        cancel.addClickShortcut(Key.ESCAPE);

        save.addClickListener(click -> fireEvent(new SaveEvent(this, binder.getBean())));
        delete.addClickListener(click -> fireEvent(new DeleteEvent(this, binder.getBean())));
        cancel.addClickListener(click -> fireEvent(new CloseEvent(this)));

        return new HorizontalLayout(save, delete, cancel);
    }

    public abstract static class MealFormEvent extends ComponentEvent<MealForm> {
        private MealDto meal;

        protected MealFormEvent(MealForm source, MealDto meal) {
            super(source, false);
            this.meal = meal;
        }

        public MealDto getMeal() {
            return meal;
        }
    }

    public static class SaveEvent extends MealFormEvent {
        SaveEvent(MealForm source, MealDto meal) {
            super(source, meal);
        }
    }

    public static class DeleteEvent extends MealFormEvent {
        DeleteEvent(MealForm source, MealDto meal) {
            super(source, meal);
        }

    }

    public static class CloseEvent extends MealFormEvent {
        CloseEvent(MealForm source) {
            super(source, null);
        }
    }

    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
                                                                  ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }
}

