package com.chess.conditions;

import com.chess.model.Piece;

public class NoMoveBaseCondition implements MoveBaseCondition{
    public boolean isBaseConditionFulfilled(Piece piece) {
        return true;
    }
}
