package pl.uncleglass.feeder.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.TemplateRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import pl.uncleglass.feeder.backend.adapters.vaadin.MealAdapter;
import pl.uncleglass.feeder.backend.adapters.vaadin.MealDto;

@Route(value="meals", layout = MainLayout.class)
@PageTitle("Meals | Karmink")
@CssImport("shared-styles.css")
public class MealsView extends VerticalLayout {
    private final MealAdapter mealAdapter;
    private final MealForm mealForm;
    private final Grid<MealDto> grid = new Grid<>();

    public MealsView(MealAdapter mealAdapter) {
        this.mealAdapter = mealAdapter;
        addClassName("list-view");
        setSizeFull();
        configureGrid();

        mealForm = new MealForm();

        mealForm.addListener(MealForm.SaveEvent.class, this::saveMeal);
        mealForm.addListener(MealForm.DeleteEvent.class, this::deleteMeal);
        mealForm.addListener(MealForm.CloseEvent.class, event -> closeEditor());

        Div content = new Div(grid, mealForm);
        content.addClassName("content");
        content.setSizeFull();


        add(getToolbar(), content);
        updateGrid();
        closeEditor();
    }

    private HorizontalLayout getToolbar() {
        Button button = new Button("Dodaj posiłek", buttonClickEvent -> addNewMeal());
        HorizontalLayout toolbar = new HorizontalLayout(button);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private void addNewMeal() {
        grid.asSingleSelect().clear();
        editContact(new MealDto());
    }

    private void deleteMeal(MealForm.DeleteEvent event) {
        mealAdapter.delete(event.getMeal());
        updateGrid();
        closeEditor();
    }

    private void saveMeal(MealForm.SaveEvent event) {
        mealAdapter.save(event.getMeal());
        updateGrid();
        closeEditor();
    }

    private void closeEditor() {
        mealForm.setMeal(new MealDto());
        mealForm.setEnabled(false);
        removeClassName("editing");
    }

    private void updateGrid() {
        grid.setItems(mealAdapter.getAll());
    }

    private void configureGrid() {
        grid.addClassName("meals-grid");
        grid.setSizeFull();

        grid.addColumn(MealDto::getName)
                .setHeader("Nazwa")
                .setSortable(true);

        grid.addColumn(TemplateRenderer.<MealDto>of(
                "<div>[[item.name]]")
                .withProperty("name", mealDto ->
                        String.join(", ", mealDto.getMealTypes())
                ))
                .setHeader("Kategoria")
                .setSortable(true)
                .setComparator((meal1, meal2) -> {
                    String str1 = String.join("", meal1.getMealTypes());
                    String str2 = String.join("", meal2.getMealTypes());
                    return str1.compareTo(str2);
                });

        grid.addColumn(MealDto::getCalories)
                .setHeader("Kalorie")
                .setSortable(true);

        grid.getColumns()
                .forEach(mealColumn -> mealColumn.setAutoWidth(true));

        grid.asSingleSelect().addValueChangeListener(event ->
                editContact(event.getValue()));
    }

    public void editContact(MealDto meal) {
        if (meal == null) {
            closeEditor();
        } else {
            mealForm.setEnabled(true);
            mealForm.setMeal(meal);
            addClassName("editing");
        }
    }
}
