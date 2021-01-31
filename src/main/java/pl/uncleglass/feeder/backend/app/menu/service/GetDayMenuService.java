package pl.uncleglass.feeder.backend.app.menu.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.uncleglass.feeder.backend.app.menu.domain.DayMenu;
import pl.uncleglass.feeder.backend.app.menu.port.in.GetDayMenuUseCase;
import pl.uncleglass.feeder.backend.app.menu.port.out.AddDayMenuPort;
import pl.uncleglass.feeder.backend.app.menu.port.out.LoadDayMenuPort;

import java.time.LocalDate;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetDayMenuService implements GetDayMenuUseCase {
    private final LoadDayMenuPort loadDayMenuPort;
    private final AddDayMenuPort addDayMenuPort;

    @Override
    public DayMenu getDayMenu(LocalDate date) {
        DayMenu dayMenu = loadDayMenuPort.loadDayMenu(date);

        if (dayMenu == null) {
            return addDayMenuPort.addDayMenu(new DayMenu(date));
        } else {
            return dayMenu;
        }
    }

    @Override
    public DayMenu getDayMenu(UUID dayMenuId) {
        return loadDayMenuPort.loadDayMenu(dayMenuId);
    }
}
