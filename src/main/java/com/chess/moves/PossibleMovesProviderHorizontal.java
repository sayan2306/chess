package com.chess.moves;

import com.chess.blockers.PieceCellOccupyBlocker;
import com.chess.conditions.MoveBaseCondition;
import com.chess.model.Board;
import com.chess.model.Cell;
import com.chess.model.Piece;
import com.chess.model.Player;

import java.util.ArrayList;
import java.util.List;

public class PossibleMovesProviderHorizontal extends PossibleMovesProvider{
    public PossibleMovesProviderHorizontal(int maxSteps, MoveBaseCondition baseCondition,
                                           PieceCellOccupyBlocker baseBlocker) {
        super(maxSteps, baseCondition, baseBlocker);
    }

    protected List<Cell> possibleMovesAsPerCurrentType(Piece piece, final Board board, List<PieceCellOccupyBlocker> additionalBlockers, Player player) {
        List<Cell> result = new ArrayList<>();
        result.addAll(findAllNextMoves(piece, board, board::getLeftCell, additionalBlockers, player));
        result.addAll(findAllNextMoves(piece, board, board::getRightCell, additionalBlockers, player));
        return result;
    }
}
