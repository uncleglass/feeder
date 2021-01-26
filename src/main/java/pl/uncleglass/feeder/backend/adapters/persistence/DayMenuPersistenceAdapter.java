package pl.uncleglass.feeder.backend.adapters.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.uncleglass.feeder.backend.app.menu.domain.DayMenu;
import pl.uncleglass.feeder.backend.app.menu.port.out.CreateDayMenuPort;
import pl.uncleglass.feeder.backend.app.menu.port.out.LoadDayMenuPort;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.UUID;

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

    @Override
    public DayMenu loadDayMenu(UUID dayMenuId) {
        DayMenuJpaEntity dayMenuJpaEntity = dayMenuRepository.findById(dayMenuId)
                .orElseThrow(EntityNotFoundException::new);
        return dayMenuMapper.mapToDomainEntity(dayMenuJpaEntity);
    }
}
