package com.techelevator.dao;

import com.techelevator.model.MusicPiece;

import java.util.List;

public interface MusicPieceDao {

    // Get a piece that has the given id
    MusicPiece getMusicPieceById(int musicPieceId);

    // Get a piece by title
    MusicPiece getMusicPieceByTitle(String title);

    // Get all pieces by a composer
    List<MusicPiece> getMusicPiecesByComposer(String composer);

    // Add a new piece
    MusicPiece addMusicPiece(MusicPiece newMusicPiece);

    // update a piece
    MusicPiece updateMusicPiece(MusicPiece updatedMusicPiece);

    // delete a piece
    int deleteMusicPieceById(int musicPieceId);
}
