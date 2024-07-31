package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Goal;
import com.techelevator.model.PracticeSession;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcGoalDao implements GoalDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcGoalDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Goal getGoalById(int goalId) {
        Goal goal = null;
        String sql = "SELECT goal_id, user_id, description, target_date, achieved, notes " +
                "FROM goal " +
                "WHERE goal_id =?";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, goalId);
            if (results.next()) {
                goal = mapRowToPracticeSession(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return goal;
    }

    @Override
    public List<Goal> getGoalsByUserId(int userId) {
        List<Goal> goals = new ArrayList<>();
        String sql = "SELECT goal_id, user_id, description, target_date, achieved, notes " +
                "FROM goal " +
                "WHERE user_id =? " +
                "ORDER BY goal_id";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
            while (results.next()) {
                Goal goal = mapRowToPracticeSession(results);
                goals.add(goal);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return goals;
    }

    @Override
    public Goal createGoal(Goal newGoal) {
        int newId;
        String sql = "INSERT INTO goal (goal_id, user_id, description, target_date, achieved, notes) " +
                "VALUES (?, ?, ?, ?, ?, ?) " +
                "RETURNING goal_id;";

        try {
            newId = jdbcTemplate.queryForObject(sql, int.class, newGoal.getGoalId(), newGoal.getUserId(), newGoal.getDescription(), newGoal.getTargetDate(), newGoal.getNotes());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        newGoal.setGoalId(newId);
        return getGoalById(newId);
    }

    @Override
    public Goal updateGoal(Goal updatedGoal) {
        Goal updateGoal = null;
        String sql = "UPDATE goal " +
                "SET goal_id = ?, user_id = ?, description = ?, target_date = ?, achieved = ?, notes = ? " +
                "WHERE goal_id = ?";

        try {
            int rowsAffected = jdbcTemplate.update(sql, updatedGoal.getGoalId(), updatedGoal.getUserId(), updatedGoal.getDescription(), updatedGoal.getTargetDate(), updatedGoal.getNotes());

            if (rowsAffected == 0) {
                throw new DaoException("Zero rows affected, expected at least one");
            } else {
                updatedGoal = getGoalById(updatedGoal.getGoalId());
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return updatedGoal;
    }

    @Override
    public int deleteGoalById(int goalId) {
        String sql = "DELETE FROM goal WHERE goal_id = ?";
        try {
            return jdbcTemplate.update(sql, goalId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
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
