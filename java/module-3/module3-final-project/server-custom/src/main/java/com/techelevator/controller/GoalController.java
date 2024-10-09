package com.techelevator.controller;

import com.techelevator.dao.GoalDao;
import com.techelevator.dao.JdbcUserDao;
import com.techelevator.model.Goal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/goal")
public class GoalController {
    @Autowired
    private GoalDao goalDao;
    @Autowired
    private JdbcUserDao jdbcUserDao;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Goal setNewGoal(@RequestBody Goal goal, Authentication authentication) {
        try {
            String username = authentication.getName();
            int userId = jdbcUserDao.getUserByUsername(username).getId();
            goal.setUsername(username);
            goal.setUserId(userId);
            return goalDao.createGoal(goal);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error setting goal - " + e.getMessage());
        }
    }

    @GetMapping
    public List<Goal> getAllGoals(Authentication authentication) {
        try {
            String username = authentication.getName();
            return goalDao.getGoalsByUsername(username);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error getting goals - " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public Goal updateGoal(@PathVariable int id, @RequestBody Goal goal, Authentication authentication) {
        try {
            String username = authentication.getName();
            int userId = jdbcUserDao.getUserByUsername(username).getId();
            goal.setUsername(username);
            goal.setGoalId(id);
            goal.setUserId(userId);
            return goalDao.updateGoal(goal);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error updating goal - " + e.getMessage());
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteGoal(@PathVariable int id, Authentication authentication) {
        try {
            goalDao.deleteGoalById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error deleting goal - " + e.getMessage());
        }
    }
}
