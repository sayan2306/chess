package com.chess.model;

public class Cell {
    private final int x;
    private final int y;
    private Piece currentPiece;

    public Cell(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isFree() {
        return this.currentPiece == null;
    }

    public Piece getCurrentPiece() {
        return this.currentPiece;
    }

    public void setCurrentPiece(Piece currentPiece) {
        this.currentPiece = currentPiece;
    }



}
