package com.chess.moves;

import com.chess.blockers.PieceCellOccupyBlocker;
import com.chess.conditions.MoveBaseCondition;
import com.chess.directions.VerticalMoveDirection;
import com.chess.model.Board;
import com.chess.model.Cell;
import com.chess.model.Piece;
import com.chess.model.Player;

import java.util.ArrayList;
import java.util.List;

public class PossibleMovesProviderVertical extends PossibleMovesProvider{
    private VerticalMoveDirection verticalMoveDirection;
    public PossibleMovesProviderVertical(int maxSteps, MoveBaseCondition baseCondition,
                                           PieceCellOccupyBlocker baseBlocker) {
        super(maxSteps, baseCondition, baseBlocker);
    }

    protected List<Cell> possibleMovesAsPerCurrentType(Piece piece, final Board board, List<PieceCellOccupyBlocker> additionalBlockers, Player player) {
        List<Cell> result = new ArrayList<>();
        if (this.verticalMoveDirection == VerticalMoveDirection.UP || this.verticalMoveDirection == VerticalMoveDirection.BOTH) {
            result.addAll(findAllNextMoves(piece, board, board::getUpCell, additionalBlockers, player));
        }
        if (this.verticalMoveDirection == VerticalMoveDirection.DOWN || this.verticalMoveDirection == VerticalMoveDirection.BOTH) {
            result.addAll(findAllNextMoves(piece, board, board::getDownCell, additionalBlockers, player));
        }
        return result;
    }

}
