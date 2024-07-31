package com.techelevator.model;

import java.time.LocalDate;

public class Goal {

    private int goalId;
    private int userId;
    private String description;
    private LocalDate targetDate;
    private boolean achieved;
    private String notes;

    public Goal() {}

    public Goal(int goalId, int userId, String description, LocalDate targetDate, boolean achieved, String notes) {
        this.goalId = goalId;
        this.userId = userId;
        this.description = description;
        this.targetDate = targetDate;
        this.achieved = achieved;
        this.notes = notes;
    }

    public int getGoalId() {
        return goalId;
    }

    public void setGoalId(int goalId) {
        this.goalId = goalId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isAchieved() {
        return achieved;
    }

    public void setAchieved(boolean achieved) {
        this.achieved = achieved;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
