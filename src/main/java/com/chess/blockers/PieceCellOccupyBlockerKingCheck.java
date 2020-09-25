package com.chess.blockers;

import com.chess.exceptions.PieceNotFoundException;
import com.chess.model.*;
import com.sun.tools.javac.platform.PlatformUtils;

public class PieceCellOccupyBlockerKingCheck implements PieceCellOccupyBlocker{
    public boolean isCellNonOccupiableForPiece(Piece piece, Cell cell, Player player, Board board) {
        Cell pieceOriginalCell = piece.getCurrentCell();
        piece.setCurrentCell(cell);
        boolean playerGettingCheckByMove = board.isPlayerOnCheck(player);
        piece.setCurrentCell(pieceOriginalCell);
        return playerGettingCheckByMove;
    }
}
