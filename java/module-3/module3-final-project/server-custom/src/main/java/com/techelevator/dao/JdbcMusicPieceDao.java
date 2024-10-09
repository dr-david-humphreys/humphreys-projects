package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.MusicPiece;
import com.techelevator.model.PracticeSession;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcMusicPieceDao implements MusicPieceDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcMusicPieceDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public MusicPiece getMusicPieceById(int musicPieceId) {
        MusicPiece musicPiece = null;
        String sql = "SELECT music_piece_id, title, composer, arranger, genre, duration " +
                "FROM music_piece " +
                "WHERE music_piece_id =?";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, musicPieceId);
            if (results.next()) {
                musicPiece = mapRowToMusicPiece(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return musicPiece;
    }

    @Override
    public MusicPiece getMusicPieceByTitle(String title) {
        MusicPiece musicPiece = null;
        String sql = "SELECT music_piece_id, title, composer, arranger, genre, duration " +
                "FROM music_piece " +
                "WHERE title =?";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, title);
            if (results.next()) {
                musicPiece = mapRowToMusicPiece(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return musicPiece;
    }

    @Override
    public List<MusicPiece> getMusicPiecesByComposer(String composer) {
        List<MusicPiece> musicPieces = new ArrayList<>();
        String sql = "SELECT music_piece_id, title, composer, arranger, genre, duration " +
                "FROM music_piece " +
                "WHERE composer =? " +
                "ORDER BY title";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, composer);
            while (results.next()) {
                MusicPiece musicPiece = mapRowToMusicPiece(results);
                musicPieces.add(musicPiece);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return musicPieces;
    }

    @Override
    public MusicPiece addMusicPiece(MusicPiece newMusicPiece) {
        int newId;
        String sql = "INSERT INTO music_piece (music_piece_id, title, composer, arranger, genre, duration) " +
                "VALUES (?, ?, ?, ?, ?, ?) " +
                "RETURNING music_piece_id;";

        try {
            newId = jdbcTemplate.queryForObject(sql, int.class, newMusicPiece.getMusicPieceId(), newMusicPiece.getTitle(), newMusicPiece.getComposer(), newMusicPiece.getArranger(), newMusicPiece.getGenre(), newMusicPiece.getDuration());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        newMusicPiece.setMusicPieceId(newId);
        return getMusicPieceById(newId);
    }

    @Override
    public MusicPiece updateMusicPiece(MusicPiece updatedMusicPiece) {
        MusicPiece updateMusicPiece = null;
        String sql = "UPDATE music_piece " +
                "SET music_piece_id = ?, title = ?, composer = ?, arranger = ?, genre = ?, duration = ? " +
                "WHERE music_piece_id = ?";

        try {
            int rowsAffected = jdbcTemplate.update(sql, updatedMusicPiece.getMusicPieceId(), updatedMusicPiece.getTitle(), updatedMusicPiece.getComposer(), updatedMusicPiece.getArranger(), updatedMusicPiece.getGenre(), updatedMusicPiece.getDuration());

            if (rowsAffected == 0) {
                throw new DaoException("Zero rows affected, expected at least one");
            } else {
                updateMusicPiece = getMusicPieceById(updatedMusicPiece.getMusicPieceId());
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return updateMusicPiece;
    }

    @Override
    public int deleteMusicPieceById(int musicPieceId) {
        String sql = "DELETE FROM music_piece WHERE music_piece_id = ?";
        try {
            return jdbcTemplate.update(sql, musicPieceId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
    }

    private MusicPiece mapRowToMusicPiece(SqlRowSet results) {
        MusicPiece musicPiece = new MusicPiece();
        musicPiece.setMusicPieceId(results.getInt("music_piece_id"));
        musicPiece.setTitle(results.getString("title"));
        musicPiece.setComposer(results.getString("composer"));
        musicPiece.setArranger(results.getString("arranger"));
        musicPiece.setGenre(results.getString("genre"));
        musicPiece.setDuration(results.getInt("duration"));
        return musicPiece;
    }
}
