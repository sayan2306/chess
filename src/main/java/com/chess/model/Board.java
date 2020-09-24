package com.chess.model;

import com.chess.blockers.PieceCellOccupyBlocker;
import com.chess.exceptions.PieceNotFoundException;
import sun.security.ec.point.ProjectivePoint;

import java.util.ArrayList;
import java.util.List;

public class Board {
    int boardSize;
    Cell[][] cells;

    public Board(int boardSize, Cell[][] cells) {
        this.boardSize = boardSize;
        this.cells = cells;
    }

    /**
     * Helper method to return cell to the left of current cell.
     */
    public Cell getLeftCell(Cell cell) {
        return getCellAtLocation(cell.getX(), cell.getY() - 1);
    }

    /**
     * Helper method to return cell to the right of current cell.
     */
    public Cell getRightCell(Cell cell) {
        return getCellAtLocation(cell.getX(), cell.getY() + 1);
    }

    /**
     * Helper method to return cell to the up of current cell.
     */
    public Cell getUpCell(Cell cell) {
        return getCellAtLocation(cell.getX() + 1, cell.getY());
    }

    /**
     * Helper method to return cell to the down of current cell.
     */
    public Cell getDownCell(Cell cell) {
        return getCellAtLocation(cell.getX() - 1, cell.getY());
    }

    public Cell getCellAtLocation(int x, int y) {
        if (x >= boardSize || x < 0) {
            return null;
        }
        if (y >= boardSize || y < 0) {
            return null;
        }
        return cells[x][y];
    }


    public boolean isPlayerOnCheck(Player player) throws PieceNotFoundException {
        return checkIfPieceCanBeKilled(player.getPiece(PieceType.KING), new ArrayList<>(), player);
    }

    public boolean checkIfPieceCanBeKilled(Piece targetPiece, List<PieceCellOccupyBlocker> cellOccupyBlockers, Player player) {
        for (int i = 0; i < this.boardSize; i++) {
            for (int j = 0; j < this.boardSize; j++) {
                Piece currentPiece = getCellAtLocation(i, j).getCurrentPiece();
                if (currentPiece != null && !currentPiece.isPieceFromSamePlayer(targetPiece)) {
                    List<Cell> nextPossibleCells = currentPiece.nextPossibleCells(this, cellOccupyBlockers, player);
                    if (nextPossibleCells.contains(targetPiece.getCurrentCell())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
