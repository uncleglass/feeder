package pl.uncleglass.feeder.ui;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import pl.uncleglass.feeder.backend.adapters.vaadin.DayMenuAdapter;
import pl.uncleglass.feeder.backend.adapters.vaadin.DayMenuDto;

import java.time.LocalDate;

@Route(value="", layout = MainLayout.class)
//
@PageTitle("Menu | Karmink")
@CssImport("shared-styles.css")
public class MenuView extends VerticalLayout {
    private final DayMenuAdapter dayMenuAdapter;
    private final Label label = new Label();


    public MenuView(DayMenuAdapter dayMenuAdapter) {
        this.dayMenuAdapter = dayMenuAdapter;
        setSizeFull();

        showDay();

    }

    private void showDay() {
        DayMenuDto dayMenu = dayMenuAdapter.getDayMenu(LocalDate.now());
        label.setText(dayMenu.getDate().toString());
        add(label);
    }

}
