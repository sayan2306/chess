package com.chess.model;

import com.chess.moves.PossibleMovesProvider;

import java.util.ArrayList;
import java.util.List;

public class Piece {
    private final Color color;
    private final PieceType pieceType;
    private boolean isKilled = false;
    private Cell currentCell;
    private final List<PossibleMovesProvider> movesProviders;

    private Integer numMoves = 0;

    public Piece(final Color color, final PieceType pieceType, final List<PossibleMovesProvider> movesProvider) {
        this.color = color;
        this.pieceType = pieceType;
        this.movesProviders = movesProvider;
    }

    public Color getColor() {
        return color;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public Cell getCurrentCell() {
        return this.currentCell;
    }

    public void setCurrentCell(Cell currentCell) {
        this.currentCell = currentCell;
    }

    public Integer getNumMoves() {
        return numMoves;
    }

    public void setNumMoves(Integer numMoves) {
        this.numMoves = numMoves;
    }

    public boolean isPieceFromSamePlayer(Piece piece) {
        return piece.getColor().equals(this.color);
    }


}
