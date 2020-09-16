package com.chess.moves;

import com.chess.blockers.PieceCellOccupyBlocker;
import com.chess.conditions.MoveBaseCondition;
import com.chess.model.Board;
import com.chess.model.Cell;
import com.chess.model.Piece;
import com.chess.model.Player;

import java.util.ArrayList;
import java.util.List;

public abstract class PossibleMovesProvider {
    int maxSteps;
    MoveBaseCondition baseCondition;
    PieceCellOccupyBlocker baseBlocker;

    public PossibleMovesProvider(int maxSteps, MoveBaseCondition baseCondition, PieceCellOccupyBlocker baseBlocker) {
        this.maxSteps = maxSteps;
        this.baseCondition = baseCondition;
        this.baseBlocker = baseBlocker;
    }

    public List<Cell> findNextPossibleMoves(Board board, List<PieceCellOccupyBlocker> additionalBlockers, Piece piece, Player player) {
        if(baseCondition.isBaseConditionFulfilled(piece)) {
            return possibleMovesAsPerCurrentType(piece, board, additionalBlockers, player);
        }
        return null;
    }

    protected abstract List<Cell> possibleMovesAsPerCurrentType(Piece piece, Board board, List<PieceCellOccupyBlocker> additionalBlockers, Player player);


    protected List<Cell> findAllNextMoves(Piece piece, Board board, NextCellProvider nextCellProvider, List<PieceCellOccupyBlocker> additionalBlockers, Player player) {
        List<Cell> result = new ArrayList<>();
        Cell nextCell = nextCellProvider.nextCell(piece.getCurrentCell());
        int numSteps = 1;
        while(nextCell != null && numSteps >= maxSteps) {
            if(checkIfCellCanBeOccupied(piece, nextCell, board, additionalBlockers, player)) {
                result.add(nextCell);
                nextCell = nextCellProvider.nextCell(nextCell);
            }
            if(!nextCell.isFree()) {
                break;
            }
            nextCell = nextCellProvider.nextCell(nextCell);
            numSteps++;
        }
        return result;
    }

    private boolean checkIfCellCanBeOccupied(Piece piece, Cell cell, Board board, List<PieceCellOccupyBlocker> additionalBlockers, Player player) {
        if (baseBlocker != null && baseBlocker.isCellNonOccupiableForPiece(piece, cell, player, board)) {
            return false;
        }
        for (PieceCellOccupyBlocker cellOccupyBlocker : additionalBlockers) {
            if (cellOccupyBlocker.isCellNonOccupiableForPiece(piece, cell, player, board)) {
                return false;
            }
        }
        return true;
    }

}
