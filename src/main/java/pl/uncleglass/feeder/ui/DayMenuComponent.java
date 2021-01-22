package pl.uncleglass.feeder.ui;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import pl.uncleglass.feeder.backend.adapters.vaadin.DayMenuDto;

public class DayMenuComponent extends Composite<Div> {
    private Label date;

    public DayMenuComponent(DayMenuDto dayMenuDto) {
        date = new Label();
        date.setText(dayMenuDto.getDate().toString());

        getContent().add(date);
    }
}
