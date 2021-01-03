package pl.uncleglass.feeder.ui;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import pl.uncleglass.feeder.backend.adapters.vaadin.DayMenuDto;
import pl.uncleglass.feeder.backend.adapters.vaadin.MenuAdapter;

@Route(value="", layout = MainLayout.class)
//
@PageTitle("Menu | Karmink")
@CssImport("shared-styles.css")
public class MenuView extends VerticalLayout {
    private final MenuAdapter menuAdapter;


    public MenuView(MenuAdapter menuAdapter) {
        this.menuAdapter = menuAdapter;
        setSizeFull();

        showDay();

    }

    private void showDay() {

    }

}
