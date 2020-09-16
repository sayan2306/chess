package com.chess.moves;

import com.chess.model.Cell;

public interface NextCellProvider {
    Cell nextCell(Cell cell);
}
