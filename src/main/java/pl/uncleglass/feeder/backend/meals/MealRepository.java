package pl.uncleglass.feeder.backend.meals;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
interface MealRepository extends JpaRepository<Meal, UUID> {
}
