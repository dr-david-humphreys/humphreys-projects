/*
package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Goal;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.util.List;

public class JdbcGoalDaoTests extends BaseDaoTests {

    private static final Goal GOAL_1 = new Goal(1, 1, "Goal Description 1", LocalDate.of(2024, 12, 31), false, "Notes 1");
    private static final Goal GOAL_2 = new Goal(2, 1, "Goal Description 2", LocalDate.of(2024, 12, 31), true, "Notes 2");
    private static final Goal GOAL_3 = new Goal(3, 2, "Goal Description 3", LocalDate.of(2024, 12, 31), false, "Notes 3");

    private JdbcGoalDao dao;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        dao = new JdbcGoalDao(jdbcTemplate);
    }

    @After
    public void cleanup() {
        // Clean up database after each test if needed
    }

    @Test
    public void getGoalById_given_valid_id_returns_goal() {
        Goal actualGoal = dao.getGoalById(GOAL_1.getGoalId());
        Assert.assertNotNull("Expected non-null goal", actualGoal);
        Assert.assertEquals("Goal ID mismatch", GOAL_1.getGoalId(), actualGoal.getGoalId());
        Assert.assertEquals("User ID mismatch", GOAL_1.getUserId(), actualGoal.getUserId());
        Assert.assertEquals("Description mismatch", GOAL_1.getDescription(), actualGoal.getDescription());
        Assert.assertEquals("Target date mismatch", GOAL_1.getTargetDate(), actualGoal.getTargetDate());
        Assert.assertEquals("Achieved mismatch", GOAL_1.isAchieved(), actualGoal.isAchieved());
        Assert.assertEquals("Notes mismatch", GOAL_1.getNotes(), actualGoal.getNotes());
    }

    @Test
    public void getGoalsByUserId_given_valid_userId_returns_goals() {
        List<Goal> goals = dao.getGoalsByUserId(1);
        Assert.assertNotNull("Expected non-null list of goals", goals);
        Assert.assertEquals("List size mismatch", 2, goals.size());
        Assert.assertTrue("List does not contain expected goal", goals.contains(GOAL_1));
        Assert.assertTrue("List does not contain expected goal", goals.contains(GOAL_2));
    }

    @Test
    public void getGoalsByUsername_given_valid_username_returns_goals() {
        // Add a goal with username
        Goal goalWithUsername = new Goal(4, 1, "Goal Description 4", LocalDate.of(2024, 7, 4), false, "Notes 4");
        goalWithUsername.setUsername("user1");
        dao.createGoal(goalWithUsername);

        List<Goal> goals = dao.getGoalsByUsername("user1");
        Assert.assertNotNull("Expected non-null list of goals", goals);
        Assert.assertEquals("List size mismatch", 1, goals.size());
        Assert.assertTrue("List does not contain expected goal", goals.contains(goalWithUsername));
    }

    @Test(expected = DaoException.class)
    public void createGoal_with_invalid_data_throws_exception() {
        // Create a goal with invalid data (e.g., invalid userId)
        dao.createGoal(new Goal(0, 0, "Invalid Goal", LocalDate.now(), false, "Invalid Notes"));
    }

    @Test
    public void createGoal_creates_new_goal() {
        Goal newGoal = new Goal(0, 1, "New Goal Description", LocalDate.of(2024, 8, 1), false, "New Notes");
        Goal createdGoal = dao.createGoal(newGoal);
        Assert.assertNotNull("Expected non-null created goal", createdGoal);
        Assert.assertEquals("User ID mismatch", newGoal.getUserId(), createdGoal.getUserId());
        Assert.assertEquals("Description mismatch", newGoal.getDescription(), createdGoal.getDescription());
        Assert.assertEquals("Target date mismatch", newGoal.getTargetDate(), createdGoal.getTargetDate());
        Assert.assertEquals("Achieved mismatch", newGoal.isAchieved(), createdGoal.isAchieved());
        Assert.assertEquals("Notes mismatch", newGoal.getNotes(), createdGoal.getNotes());
    }

    @Test
    public void updateGoal_updates_existing_goal() {
        Goal goalToUpdate = new Goal(GOAL_1.getGoalId(), 1, "Updated Description", LocalDate.of(2024, 12, 31), true, "Updated Notes");
        Goal updatedGoal = dao.updateGoal(goalToUpdate);
        Assert.assertNotNull("Expected non-null updated goal", updatedGoal);
        Assert.assertEquals("Description mismatch", goalToUpdate.getDescription(), updatedGoal.getDescription());
        Assert.assertEquals("Achieved mismatch", goalToUpdate.isAchieved(), updatedGoal.isAchieved());
        Assert.assertEquals("Notes mismatch", goalToUpdate.getNotes(), updatedGoal.getNotes());
    }

    @Test
    public void deleteGoalById_deletes_existing_goal() {
        int rowsAffected = dao.deleteGoalById(GOAL_3.getGoalId());
        Assert.assertEquals("Expected one row to be affected", 1, rowsAffected);
        Goal deletedGoal = dao.getGoalById(GOAL_3.getGoalId());
        Assert.assertNull("Expected null goal after deletion", deletedGoal);
    }
}

 */