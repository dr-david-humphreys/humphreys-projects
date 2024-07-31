package com.techelevator.model;

public class MusicPiece {

    private int musicPieceId;
    private String title;
    private String composer;
    private String arranger;
    private String genre;
    private int duration;

    public MusicPiece() {}

    public MusicPiece(int musicPieceId, String title, String composer, String arranger, String genre, int duration) {
        this.musicPieceId = musicPieceId;
        this.title = title;
        this. composer = composer;
        this.arranger = arranger;
        this.genre = genre;
        this.duration = duration;
    }

    public int getMusicPieceId() {
        return musicPieceId;
    }

    public void setMusicPieceId(int musicPieceId) {
        this.musicPieceId = musicPieceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public String getArranger() {
        return arranger;
    }

    public void setArranger(String arranger) {
        this.arranger = arranger;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
