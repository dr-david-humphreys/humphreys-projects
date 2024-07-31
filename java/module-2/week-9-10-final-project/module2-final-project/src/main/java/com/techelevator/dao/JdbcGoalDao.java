package com.techelevator.dao;

import com.techelevator.model.Goal;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.List;

public class JdbcGoalDao implements GoalDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcGoalDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Goal getGoalById(int goalId) {
        return null;
    }

    @Override
    public List<Goal> getGoalsByUserId(int userId) {
        return null;
    }

    @Override
    public Goal createGoal(Goal newGoal) {
        return null;
    }

    @Override
    public Goal updateGoal(Goal updatedGoal) {
        return null;
    }

    @Override
    public int deleteGoalById(int goalId) {
        return 0;
    }

    private Goal mapRowToPracticeSession(SqlRowSet results) {
        Goal goal = new Goal();
        goal.setGoalId(results.getInt("goal_id"));
        goal.setUserId(results.getInt("user_id"));
        goal.setDescription(results.getString("description"));
        goal.setTargetDate(results.getDate("target_date").toLocalDate());
        goal.setAchieved(results.getBoolean("achieved"));
        goal.setNotes(results.getString("notes"));
        return goal;
    }
}
