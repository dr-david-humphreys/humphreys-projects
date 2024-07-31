package com.techelevator.dao;

import com.techelevator.model.Goal;

import java.util.List;

public interface GoalDao {

    // Get a goal that has the given id
    Goal getGoalById(int goalId);

    // Get all goals for a single user
    List<Goal> getGoalsByUserId(int userId);

    // Add a new goal
    Goal createGoal(Goal newGoal);

    // Update a goal
    Goal updateGoal(Goal updatedGoal);

    // Delete a goal
    int deleteGoalById(int goalId);
}
