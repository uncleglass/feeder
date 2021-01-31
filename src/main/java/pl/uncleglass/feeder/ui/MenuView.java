package pl.uncleglass.feeder.ui;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import pl.uncleglass.feeder.backend.adapters.vaadin.DayMenuAdapter;
import pl.uncleglass.feeder.backend.adapters.vaadin.DayMenuDto;

import java.time.LocalDate;

@Route(value = "", layout = MainLayout.class)
//
@PageTitle("Menu | Karmink")
@CssImport("shared-styles.css")
public class MenuView extends VerticalLayout {
    private static final int DAYS_COUNT_TO_DISPLAY = 7;
    private final DayMenuAdapter dayMenuAdapter;

    public MenuView(DayMenuAdapter dayMenuAdapter) {
        this.dayMenuAdapter = dayMenuAdapter;
        setSizeFull();
        showDays();
    }

    private void showDays() {
        HorizontalLayout layout = new HorizontalLayout();
        layout.setWidth("max-content");
        LocalDate date = LocalDate.now();

        for (int i = 0; i < DAYS_COUNT_TO_DISPLAY; i++) {
            DayMenuDto dayMenu = dayMenuAdapter.getDayMenu(date.plusDays(i));
            DayMenuComponent component = new DayMenuComponent(dayMenu);
            layout.add(component);
        }

        Scroller scroller = new Scroller();
        scroller.setScrollDirection(Scroller.ScrollDirection.HORIZONTAL);
        scroller.setContent(layout);
        add(scroller);
    }
}
