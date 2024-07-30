package com.techelevator.model;

import java.time.LocalDate;

public class PracticeSession {

    private int practiceSessionId;
    private int userId;
    private LocalDate date;
    private int duration;
    private String piecesPracticed;
    private String notes;

    public PracticeSession() {}

    public PracticeSession(int practiceSessionId, int userId, LocalDate date, int duration, String piecesPracticed, String notes) {
        this.practiceSessionId = practiceSessionId;
        this.userId = userId;
        this.date = date;
        this.duration = duration;
        this.piecesPracticed = piecesPracticed;
        this.notes = notes;
    }

    public int getPracticeSessionId() {
        return practiceSessionId;
    }

    public void setPracticeSessionId(int practiceSessionId) {
        this.practiceSessionId = practiceSessionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getPiecesPracticed() {
        return piecesPracticed;
    }

    public void setPiecesPracticed(String piecesPracticed) {
        this.piecesPracticed = piecesPracticed;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
