package com.chess.conditions;

import com.chess.model.Piece;

public interface MoveBaseCondition {
    boolean isBaseConditionFulfilled(Piece piece);
}
