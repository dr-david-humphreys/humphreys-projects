package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.MusicPiece;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcMusicPieceDaoTests extends BaseDaoTests {

    private static final MusicPiece MUSIC_PIECE_1 = new MusicPiece(1, "Title 1", "Composer 1", "Arranger 1", "Genre 1", 180);
    private static final MusicPiece MUSIC_PIECE_2 = new MusicPiece(2, "Title 2", "Composer 1", "Arranger 2", "Genre 2", 240);
    private static final MusicPiece MUSIC_PIECE_3 = new MusicPiece(3, "Title 3", "Composer 2", "Arranger 3", "Genre 1", 300);

    private JdbcMusicPieceDao dao;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        dao = new JdbcMusicPieceDao(jdbcTemplate);
    }

    @After
    public void cleanup() {
        // Clean up database after each test if needed
    }

    @Test
    public void getMusicPieceById_given_valid_id_returns_music_piece() {
        MusicPiece actualMusicPiece = dao.getMusicPieceById(MUSIC_PIECE_1.getMusicPieceId());
        Assert.assertNotNull("Expected non-null music piece", actualMusicPiece);
        Assert.assertEquals("Music piece ID mismatch", MUSIC_PIECE_1.getMusicPieceId(), actualMusicPiece.getMusicPieceId());
        Assert.assertEquals("Title mismatch", MUSIC_PIECE_1.getTitle(), actualMusicPiece.getTitle());
        Assert.assertEquals("Composer mismatch", MUSIC_PIECE_1.getComposer(), actualMusicPiece.getComposer());
        Assert.assertEquals("Arranger mismatch", MUSIC_PIECE_1.getArranger(), actualMusicPiece.getArranger());
        Assert.assertEquals("Genre mismatch", MUSIC_PIECE_1.getGenre(), actualMusicPiece.getGenre());
        Assert.assertEquals("Duration mismatch", MUSIC_PIECE_1.getDuration(), actualMusicPiece.getDuration());
    }

    @Test
    public void getMusicPieceByTitle_given_valid_title_returns_music_piece() {
        MusicPiece actualMusicPiece = dao.getMusicPieceByTitle(MUSIC_PIECE_1.getTitle());
        Assert.assertNotNull("Expected non-null music piece", actualMusicPiece);
        Assert.assertEquals("Title mismatch", MUSIC_PIECE_1.getTitle(), actualMusicPiece.getTitle());
    }

    @Test
    public void getMusicPiecesByComposer_given_valid_composer_returns_music_pieces() {
        List<MusicPiece> musicPieces = dao.getMusicPiecesByComposer("Composer 1");
        Assert.assertNotNull("Expected non-null list of music pieces", musicPieces);
        Assert.assertEquals("List size mismatch", 2, musicPieces.size());
        Assert.assertTrue("List does not contain expected music piece", musicPieces.contains(MUSIC_PIECE_1));
        Assert.assertTrue("List does not contain expected music piece", musicPieces.contains(MUSIC_PIECE_2));
    }

    @Test
    public void addMusicPiece_creates_new_music_piece() {
        MusicPiece newMusicPiece = new MusicPiece(0, "New Title", "New Composer", "New Arranger", "New Genre", 360);
        MusicPiece createdMusicPiece = dao.addMusicPiece(newMusicPiece);
        Assert.assertNotNull("Expected non-null created music piece", createdMusicPiece);
        Assert.assertEquals("Title mismatch", newMusicPiece.getTitle(), createdMusicPiece.getTitle());
        Assert.assertEquals("Composer mismatch", newMusicPiece.getComposer(), createdMusicPiece.getComposer());
        Assert.assertEquals("Arranger mismatch", newMusicPiece.getArranger(), createdMusicPiece.getArranger());
        Assert.assertEquals("Genre mismatch", newMusicPiece.getGenre(), createdMusicPiece.getGenre());
        Assert.assertEquals("Duration mismatch", newMusicPiece.getDuration(), createdMusicPiece.getDuration());
    }

    @Test
    public void updateMusicPiece_updates_existing_music_piece() {
        MusicPiece musicPieceToUpdate = new MusicPiece(MUSIC_PIECE_1.getMusicPieceId(), "Updated Title", "Updated Composer", "Updated Arranger", "Updated Genre", 400);
        MusicPiece updatedMusicPiece = dao.updateMusicPiece(musicPieceToUpdate);
        Assert.assertNotNull("Expected non-null updated music piece", updatedMusicPiece);
        Assert.assertEquals("Title mismatch", musicPieceToUpdate.getTitle(), updatedMusicPiece.getTitle());
        Assert.assertEquals("Composer mismatch", musicPieceToUpdate.getComposer(), updatedMusicPiece.getComposer());
        Assert.assertEquals("Arranger mismatch", musicPieceToUpdate.getArranger(), updatedMusicPiece.getArranger());
        Assert.assertEquals("Genre mismatch", musicPieceToUpdate.getGenre(), updatedMusicPiece.getGenre());
        Assert.assertEquals("Duration mismatch", musicPieceToUpdate.getDuration(), updatedMusicPiece.getDuration());
    }

    @Test
    public void deleteMusicPieceById_deletes_existing_music_piece() {
        int rowsAffected = dao.deleteMusicPieceById(MUSIC_PIECE_3.getMusicPieceId());
        Assert.assertEquals("Expected one row to be affected", 1, rowsAffected);
        MusicPiece deletedMusicPiece = dao.getMusicPieceById(MUSIC_PIECE_3.getMusicPieceId());
        Assert.assertNull("Expected null music piece after deletion", deletedMusicPiece);
    }
}
