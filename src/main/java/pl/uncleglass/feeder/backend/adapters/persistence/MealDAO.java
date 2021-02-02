package pl.uncleglass.feeder.backend.adapters.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
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

        int mealId = (int) insert.executeAndReturnKey(parameters);

        String sqlType = "INSERT INTO MEAL_TYPE(MEAL_ID, MEAL_TYPE_ID) VALUES(?,?)";
        Set<Integer> mealTypes = mealEntity.getMealTypes();
        mealTypes.forEach(mealTypeId ->
                jdbcTemplate.update(sqlType, mealId, mealTypeId));
    }

    public List<MealEntity> loadMeals() {
        String sql = "SELECT M.id, M.name, M.description, M.notes, M.calories, T.meal_type_id FROM MEALS AS M " +
                "LEFT JOIN MEAL_TYPE AS T ON M.id = T.meal_id";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        Map<Long, MealEntity> mealsById = new HashMap<>();
        while (rowSet.next()) {
            Long id = rowSet.getLong("id");
            String name = rowSet.getString("name");
            String description = rowSet.getString("description");
            String notes = rowSet.getString("notes");
            Integer calories = rowSet.getInt("calories");
            Integer mealTypeId = rowSet.getInt("meal_type_id");
            MealEntity meal = mealsById.get(id);
            if (meal == null) {
                meal = new MealEntity();
                meal.setId(id);
                meal.setName(name);
                meal.setDescription(description);
                meal.setNotes(notes);
                meal.setCalories(calories);

                mealsById.put(meal.getId(), meal);
            }
            meal.addMealType(mealTypeId);
        }
        Collection<MealEntity> values = mealsById.values();
        return new ArrayList<>(values);
    }

    public void updateMeal(MealEntity mealEntity) {
        String sqlMeal = "update meals set name=?, description=?, notes=?, calories=? where id=?";
        jdbcTemplate.update(
                sqlMeal,
                mealEntity.getName(),
                mealEntity.getDescription(),
                mealEntity.getNotes(),
                mealEntity.getCalories(),
                mealEntity.getId()
        );

        String sqlDeleteType = "delete from meal_type where meal_id=?";
        jdbcTemplate.update(sqlDeleteType, mealEntity.getId());

        String sqlInsertType = "insert into meal_type(meal_id, meal_type_id) VALUES(?,?)";
        Set<Integer> mealTypes = mealEntity.getMealTypes();
        mealTypes.forEach(mealTypeId ->
                jdbcTemplate.update(sqlInsertType, mealEntity.getId(), mealTypeId));
    }

    public void deleteMeal(MealEntity mealEntity) {
        String sqlDeleteType = "delete from meal_type where meal_id=?";
        jdbcTemplate.update(sqlDeleteType, mealEntity.getId());

        String sqlDeleteMeal = "delete from meals where id=?";
        jdbcTemplate.update(sqlDeleteMeal, mealEntity.getId());
    }
}
