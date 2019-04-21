package com.cperbony.chess_system.chess;

import com.cperbony.chess_system.boardgame.Board;
import com.cperbony.chess_system.boardgame.Piece;

public class ChessPiece extends Piece {

    private Color color;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
