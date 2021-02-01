package pl.uncleglass.feeder.backend.adapters.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class MealDAO {
    private final JdbcTemplate jdbcTemplate;

    public void saveNewMeal(MealEntity mealEntity) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
        insert.withTableName("MEALS").usingGeneratedKeyColumns("ID");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("NAME", mealEntity.getName());
        parameters.put("DESCRIPTION", mealEntity.getDescription());
        parameters.put("NOTES", mealEntity.getNotes());
        parameters.put("CALORIES", mealEntity.getCalories());

        int mealId =  (int) insert.executeAndReturnKey(parameters);

        String sqlType = "INSERT INTO MEAL_TYPE(MEAL_ID, MEAL_TYPE_ID) VALUES(?,?)";
        Set<Integer> mealTypes = mealEntity.getMealTypes();
        mealTypes.forEach(mealTypeId -> {
            jdbcTemplate.update(sqlType, mealId, mealTypeId);
        });
    }
}
