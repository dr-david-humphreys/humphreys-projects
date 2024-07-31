package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.PracticeSession;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.util.List;

public class JdbcPracticeSessionDaoTests extends BaseDaoTests {

    private static final PracticeSession PRACTICE_SESSION_1 = new PracticeSession(1, 1, LocalDate.of(2024, 7, 1), 60, "Piece A", "Notes A");
    private static final PracticeSession PRACTICE_SESSION_2 = new PracticeSession(2, 1, LocalDate.of(2024, 7, 2), 45, "Piece B", "Notes B");
    private static final PracticeSession PRACTICE_SESSION_3 = new PracticeSession(3, 2, LocalDate.of(2024, 7, 3), 30, "Piece C", "Notes C");

    private JdbcPracticeSessionDao dao;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        dao = new JdbcPracticeSessionDao(jdbcTemplate);
    }

    @Test
    public void getPracticeSessionById_given_invalid_id_returns_null() {
        PracticeSession practiceSession = dao.getPracticeSessionById(-1);
        Assert.assertNull("getPracticeSessionById with invalid id did not return null", practiceSession);
    }

    @Test
    public void getPracticeSessionById_given_valid_id_returns_practice_session() {
        PracticeSession actualPracticeSession = dao.getPracticeSessionById(PRACTICE_SESSION_1.getPracticeSessionId());
        Assert.assertEquals("getPracticeSessionById with valid id did not return correct practice session", PRACTICE_SESSION_1, actualPracticeSession);
    }

    @Test
    public void getPracticeSessionsByUserId_given_invalid_user_id_returns_empty_list() {
        List<PracticeSession> practiceSessions = dao.getPracticeSessionsByUserId(-1);
        Assert.assertTrue("getPracticeSessionsByUserId with invalid userId did not return empty list", practiceSessions.isEmpty());
    }

    @Test
    public void getPracticeSessionsByUserId_given_valid_user_id_returns_correct_sessions() {
        List<PracticeSession> practiceSessions = dao.getPracticeSessionsByUserId(1);
        Assert.assertNotNull("getPracticeSessionsByUserId returned null list", practiceSessions);
        Assert.assertEquals("getPracticeSessionsByUserId returned list with incorrect number of practice sessions", 2, practiceSessions.size());
        Assert.assertEquals("getPracticeSessionsByUserId returned list in incorrect order", PRACTICE_SESSION_1, practiceSessions.get(0));
        Assert.assertEquals("getPracticeSessionsByUserId returned list in incorrect order", PRACTICE_SESSION_2, practiceSessions.get(1));
    }

    @Test
    public void getPracticeSessionsByUsername_given_invalid_username_returns_empty_list() {
        List<PracticeSession> practiceSessions = dao.getPracticeSessionsByUsername("invalid");
        Assert.assertTrue("getPracticeSessionsByUsername with invalid username did not return empty list", practiceSessions.isEmpty());
    }

    @Test
    public void getPracticeSessionsByUsername_given_valid_username_returns_correct_sessions() {
        List<PracticeSession> practiceSessions = dao.getPracticeSessionsByUsername("user1");
        Assert.assertNotNull("getPracticeSessionsByUsername returned null list", practiceSessions);
        Assert.assertEquals("getPracticeSessionsByUsername returned list with incorrect number of practice sessions", 2, practiceSessions.size());
        Assert.assertEquals("getPracticeSessionsByUsername returned list in incorrect order", PRACTICE_SESSION_1, practiceSessions.get(0));
        Assert.assertEquals("getPracticeSessionsByUsername returned list in incorrect order", PRACTICE_SESSION_2, practiceSessions.get(1));
    }

    @Test(expected = DaoException.class)
    public void createPracticeSession_with_invalid_data_throws_exception() {
        dao.createPracticeSession(new PracticeSession(0, 1, LocalDate.now(), 60, "Piece", null));
    }

    @Test
    public void createPracticeSession_creates_a_practice_session() {
        PracticeSession newPracticeSession = new PracticeSession(0, 1, LocalDate.of(2024, 7, 15), 90, "New Piece", "New Notes");

        PracticeSession createdPracticeSession = dao.createPracticeSession(newPracticeSession);
        Assert.assertNotNull("Call to create should return non-null practice session", createdPracticeSession);

        PracticeSession actualPracticeSession = dao.getPracticeSessionById(createdPracticeSession.getPracticeSessionId());
        Assert.assertNotNull("Call to getPracticeSessionById after call to create should return non-null practice session", actualPracticeSession);

        newPracticeSession.setPracticeSessionId(actualPracticeSession.getPracticeSessionId());
        Assert.assertEquals(newPracticeSession, actualPracticeSession);
    }

    @Test
    public void updatePracticeSession_updates_a_practice_session() {
        PracticeSession updatedPracticeSession = new PracticeSession(PRACTICE_SESSION_1.getPracticeSessionId(), PRACTICE_SESSION_1.getUserId(), LocalDate.of(2024, 7, 1), 70, "Updated Piece", "Updated Notes");

        PracticeSession result = dao.updatePracticeSession(updatedPracticeSession);
        Assert.assertNotNull("Call to update should return non-null practice session", result);
        Assert.assertEquals("Updated practice session does not match expected values", updatedPracticeSession, result);
    }

    @Test
    public void deletePracticeSessionById_deletes_a_practice_session() {
        int rowsDeleted = dao.deletePracticeSessionById(PRACTICE_SESSION_1.getPracticeSessionId());
        Assert.assertEquals("Delete did not affect the correct number of rows", 1, rowsDeleted);

        PracticeSession practiceSession = dao.getPracticeSessionById(PRACTICE_SESSION_1.getPracticeSessionId());
        Assert.assertNull("getPracticeSessionById after delete did not return null", practiceSession);
    }
}