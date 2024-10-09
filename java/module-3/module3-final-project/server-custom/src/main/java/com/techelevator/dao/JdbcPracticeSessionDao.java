package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.PracticeSession;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPracticeSessionDao implements PracticeSessionDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPracticeSessionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public PracticeSession getPracticeSessionById(int practiceSessionId) {
        PracticeSession practiceSession = null;
        String sql = "SELECT ps.practice_session_id, ps.user_id, ps.date, ps.duration, ps.pieces_practiced, ps.notes, u.username " +
                "FROM practice_session ps " +
                "JOIN users u ON ps.user_id = u.user_id " +
                "WHERE ps.practice_session_id = ?";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, practiceSessionId);
            if (results.next()) {
                practiceSession = mapRowToPracticeSession(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return practiceSession;
    }

    @Override
    public List<PracticeSession> getPracticeSessionsByUserId(int userId) {
        List<PracticeSession> practiceSessions = new ArrayList<>();
        String sql = "SELECT ps.practice_session_id, ps.user_id, ps.date, ps.duration, ps.pieces_practiced, ps.notes, u.username " +
                "FROM practice_session ps " +
                "JOIN users u ON ps.user_id = u.user_id " +
                "WHERE ps.user_id = ? " +
                "ORDER BY ps.practice_session_id";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
            while (results.next()) {
                PracticeSession practiceSession = mapRowToPracticeSession(results);
                practiceSessions.add(practiceSession);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return practiceSessions;
    }

    @Override
    public List<PracticeSession> getPracticeSessionsByUsername(String username) {
        List<PracticeSession> practiceSessions = new ArrayList<>();
        String sql = "SELECT ps.practice_session_id, ps.user_id, ps.date, ps.duration, ps.pieces_practiced, ps.notes, u.username " +
                "FROM practice_session ps " +
                "JOIN users u ON ps.user_id = u.user_id " +
                "WHERE u.username = ? " +
                "ORDER BY ps.practice_session_id";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username);
            while (results.next()) {
                PracticeSession practiceSession = mapRowToPracticeSession(results);
                practiceSessions.add(practiceSession);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return practiceSessions;
    }

    @Override
    public PracticeSession createPracticeSession(PracticeSession newPracticeSession) {
        int newId;
        String sql = "INSERT INTO practice_session (user_id, date, duration, pieces_practiced, notes) " +
                "VALUES (?, ?, ?, ?, ?) " +
                "RETURNING practice_session_id;";

        try {
            newId = jdbcTemplate.queryForObject(sql, int.class, newPracticeSession.getUserId(), newPracticeSession.getDate(), newPracticeSession.getDuration(), newPracticeSession.getPiecesPracticed(), newPracticeSession.getNotes());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        newPracticeSession.setPracticeSessionId(newId);
        return getPracticeSessionById(newId);
    }

    @Override
    public PracticeSession updatePracticeSession(PracticeSession updatedPracticeSession) {
        PracticeSession updatePracticeSession = null;
        String sql = "UPDATE practice_session " +
                "SET user_id = ?, date = ?, duration = ?, pieces_practiced = ?, notes = ? " +
                "WHERE practice_session_id = ?";

        try {
            int rowsAffected = jdbcTemplate.update(sql, updatedPracticeSession.getUserId(), updatedPracticeSession.getDate(), updatedPracticeSession.getDuration(), updatedPracticeSession.getPiecesPracticed(), updatedPracticeSession.getNotes(), updatedPracticeSession.getPracticeSessionId());

            if (rowsAffected == 0) {
                throw new DaoException("Zero rows affected, expected at least one");
            } else {
                updatePracticeSession = getPracticeSessionById(updatedPracticeSession.getPracticeSessionId());
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return updatePracticeSession;
    }

    @Override
    public int deletePracticeSessionById(int practiceSessionId) {
        String sql = "DELETE FROM practice_session WHERE practice_session_id = ?";
        try {
            return jdbcTemplate.update(sql, practiceSessionId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
    }

    private PracticeSession mapRowToPracticeSession(SqlRowSet results) {
        PracticeSession practiceSession = new PracticeSession();
        practiceSession.setPracticeSessionId(results.getInt("practice_session_id"));
        practiceSession.setUserId(results.getInt("user_id"));
        practiceSession.setDate(results.getDate("date").toLocalDate());
        practiceSession.setDuration(results.getInt("duration"));
        practiceSession.setPiecesPracticed(results.getString("pieces_practiced"));
        practiceSession.setNotes(results.getString("notes"));
        practiceSession.setUsername(results.getString("username"));
        return practiceSession;
    }
}
