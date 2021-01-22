package pl.uncleglass.feeder.backend.adapters.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.uncleglass.feeder.backend.app.menu.domain.DayMenu;
import pl.uncleglass.feeder.backend.app.menu.port.out.CreateDayMenuPort;
import pl.uncleglass.feeder.backend.app.menu.port.out.LoadDayMenuPort;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
class DayMenuPersistenceAdapter implements CreateDayMenuPort, LoadDayMenuPort {
    private final DayMenuRepository dayMenuRepository;
    private final DayMenuMapper dayMenuMapper;

    @Override
    public DayMenu createDayMenu(DayMenu dayMenu) {
        DayMenuJpaEntity saved = dayMenuRepository.save(dayMenuMapper.mapToJpaEntity(dayMenu));
        return dayMenuMapper.mapToDomainEntity(saved);
    }

    @Override
    public DayMenu loadDayMenu(LocalDate date) {
        DayMenuJpaEntity byDate = dayMenuRepository.findDayMenuJpaEntitiesByDate(date);
        return dayMenuMapper.mapToDomainEntity(byDate);
    }
}
