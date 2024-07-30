package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.PracticeSession;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.List;

public class JdbcPracticeSessionDao implements PracticeSessionDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPracticeSessionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public PracticeSession getPracticeSessionById(int practiceSessionId) {
        PracticeSession practiceSession = null;
        String sql = "SELECT practice_session_id, user_id, date, duration, pieces_practiced, notes FROM practice_session WHERE practice_session_id =?";

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
        return null;
    }

    @Override
    public PracticeSession createPracticeSession(PracticeSession newPracticeSession) {
        return null;
    }

    @Override
    public PracticeSession updatePracticeSession(PracticeSession updatedPracticeSession) {
        return null;
    }

    @Override
    public int deletePracticeSessionById(int practiceSessionId) {
        return 0;
    }

    private PracticeSession mapRowToPracticeSession(SqlRowSet results) {
        PracticeSession practiceSession = new PracticeSession();
        practiceSession.setPracticeSessionId(results.getInt("practice_session_id"));
        practiceSession.setUserId(results.getInt("user_id"));
        practiceSession.setDate(results.getDate("date").toLocalDate());
        practiceSession.setDuration(results.getInt("duration"));
        practiceSession.setPiecesPracticed(results.getString("pieces_practiced"));
        practiceSession.setNotes(results.getString("notes"));
        return practiceSession;
    }
}
