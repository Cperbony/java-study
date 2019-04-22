package com.cperbony.chess_system.chess.pieces;

import com.cperbony.chess_system.boardgame.Board;
import com.cperbony.chess_system.chess.ChessPiece;
import com.cperbony.chess_system.chess.Color;

public class King extends ChessPiece {
    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }
}
