package com.techelevator.dao;

import com.techelevator.model.PracticeSession;

import java.util.List;

public interface PracticeSessionDao {

    // Get a practice session that has the given id
    PracticeSession getPracticeSessionById(int practiceSessionId);

    // Get all practice sessions for a single user
    List<PracticeSession> getPracticeSessionsByUserId(int userId);

    // Add a new practice session
    PracticeSession createPracticeSession(PracticeSession newPracticeSession);

    // Update a practice session
    PracticeSession updatePracticeSession(PracticeSession updatedPracticeSession);

    // Delete a practice session
    int deletePracticeSessionById(int practiceSessionId);
}
