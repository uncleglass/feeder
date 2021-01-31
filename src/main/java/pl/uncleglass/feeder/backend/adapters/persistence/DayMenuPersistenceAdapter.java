package pl.uncleglass.feeder.backend.adapters.persistence;

import org.springframework.stereotype.Component;
import pl.uncleglass.feeder.backend.app.menu.domain.DayMenu;
import pl.uncleglass.feeder.backend.app.menu.port.out.AddDayMenuPort;
import pl.uncleglass.feeder.backend.app.menu.port.out.LoadDayMenuPort;

import java.time.LocalDate;
import java.util.UUID;

@Component
public class DayMenuPersistenceAdapter implements
        AddDayMenuPort,
        LoadDayMenuPort {
    @Override
    public DayMenu addDayMenu(DayMenu dayMenu) {
        return new DayMenu(null, null, null);
    }

    @Override
    public DayMenu loadDayMenu(LocalDate date) {
        return new DayMenu(null, null, null);
    }

    @Override
    public DayMenu loadDayMenu(UUID dayMenuId) {
        return new DayMenu(null, null, null);
    }
}
