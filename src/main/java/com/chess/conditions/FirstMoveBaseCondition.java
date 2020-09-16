package com.chess.conditions;

import com.chess.model.Piece;

public class FirstMoveBaseCondition implements MoveBaseCondition {
    public boolean isBaseConditionFulfilled(Piece piece) {
        return piece.getNumMoves() == 0;
    }
}
