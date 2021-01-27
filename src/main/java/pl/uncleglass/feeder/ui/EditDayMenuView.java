package pl.uncleglass.feeder.ui;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import pl.uncleglass.feeder.backend.adapters.vaadin.DayMenuAdapter;
import pl.uncleglass.feeder.backend.adapters.vaadin.DayMenuDto;

import java.util.UUID;

@Route(value = "edit-day-menu", layout = MainLayout.class)
public class EditDayMenuView extends VerticalLayout implements HasUrlParameter<String>, AfterNavigationObserver {
    Label date = new Label();
    private final DayMenuAdapter dayMenuAdapter;
    private DayMenuDto dayMenuDto;

    public EditDayMenuView(DayMenuAdapter dayMenuAdapter) {
        this.dayMenuAdapter = dayMenuAdapter;
        add(date);
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
