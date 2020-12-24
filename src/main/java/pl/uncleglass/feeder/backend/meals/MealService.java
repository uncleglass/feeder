package pl.uncleglass.feeder.backend.meals;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {
    private final MealRepository mealRepository;


    public MealService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    public List<Meal> getAll() {
        return mealRepository.findAll();
    }

    public void delete(Meal meal) {
        mealRepository.delete(meal);
    }

    public void save(Meal meal) {
        mealRepository.save(meal);
    }
}
