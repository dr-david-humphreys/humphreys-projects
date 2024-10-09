package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Goal;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcGoalDao implements GoalDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcGoalDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Goal getGoalById(int goalId) {
        Goal goal = null;
        String sql = "SELECT g.goal_id, g.user_id, g.description, g.target_date, g.achieved, g.notes, u.username " +
                "FROM goal g " +
                "JOIN users u ON g.user_id = u.user_id " +
                "WHERE g.goal_id = ?";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, goalId);
            if (results.next()) {
                goal = mapRowToGoal(results);
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
        String sql = "SELECT g.goal_id, g.user_id, g.description, g.target_date, g.achieved, g.notes, u.username " +
                "FROM goal g " +
                "JOIN users u ON g.user_id = u.user_id " +
                "WHERE g.user_id = ? " +
                "ORDER BY g.goal_id";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
            while (results.next()) {
                Goal goal = mapRowToGoal(results);
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
    public List<Goal> getGoalsByUsername(String username) {
        List<Goal> goals = new ArrayList<>();
        String sql = "SELECT g.goal_id, g.user_id, g.description, g.target_date, g.achieved, g.notes, u.username " +
                "FROM goal g " +
                "JOIN users u ON g.user_id = u.user_id " +
                "WHERE u.username = ? " +
                "ORDER BY g.goal_id";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username);
            while (results.next()) {
                Goal goal = mapRowToGoal(results);
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
        String sql = "INSERT INTO goal (user_id, description, target_date, achieved, notes) " +
                "VALUES (?, ?, ?, ?, ?) " +
                "RETURNING goal_id";

        try {
            newId = jdbcTemplate.queryForObject(sql, int.class, newGoal.getUserId(), newGoal.getDescription(), newGoal.getTargetDate(), newGoal.isAchieved(), newGoal.getNotes());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        newGoal.setGoalId(newId);
        return getGoalById(newId);
    }

    @Override
    public Goal updateGoal(Goal updatedGoal) {
        Goal updateGoal = null;
        String sql = "UPDATE goal " +
                "SET user_id = ?, description = ?, target_date = ?, achieved = ?, notes = ? " +
                "WHERE goal_id = ?";

        try {
            int rowsAffected = jdbcTemplate.update(sql, updatedGoal.getUserId(), updatedGoal.getDescription(), updatedGoal.getTargetDate(), updatedGoal.isAchieved(), updatedGoal.getNotes(), updatedGoal.getGoalId());

            if (rowsAffected == 0) {
                throw new DaoException("Zero rows affected, expected at least one");
            } else {
                updateGoal = getGoalById(updatedGoal.getGoalId());
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return updateGoal;
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

    private Goal mapRowToGoal(SqlRowSet results) {
        Goal goal = new Goal();
        goal.setGoalId(results.getInt("goal_id"));
        goal.setUserId(results.getInt("user_id"));
        goal.setDescription(results.getString("description"));
        goal.setTargetDate(results.getDate("target_date").toLocalDate());
        goal.setAchieved(results.getBoolean("achieved"));
        goal.setNotes(results.getString("notes"));
        goal.setUsername(results.getString("username"));
        return goal;
    }
}
