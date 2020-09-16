package com.chess.blockers;

import com.chess.model.Board;
import com.chess.model.Cell;
import com.chess.model.Piece;
import com.chess.model.Player;

public class PieceCellOccupyBlockerSamePlayerCheck implements PieceCellOccupyBlocker {

    public boolean isCellNonOccupiableForPiece(Piece piece, Cell cell, Player player, Board board) {
        if (cell.isFree()) {
            return false;
        }
        return cell.getCurrentPiece().getColor() == piece.getColor();
    }
}
