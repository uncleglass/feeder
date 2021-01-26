package pl.uncleglass.feeder.ui;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;

@Route(value = "edit-day-menu", layout = MainLayout.class)
public class EditDayMenuView extends VerticalLayout implements HasUrlParameter<String> {
    Label label = new Label();

    public EditDayMenuView() {
        add(label);
    }

    @Override
    public void setParameter(BeforeEvent event, String parameter) {
        label.setText(parameter);
    }
}
