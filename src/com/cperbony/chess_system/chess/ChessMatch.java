package com.cperbony.chess_system.chess;

import com.cperbony.chess_system.boardgame.Board;
import com.cperbony.chess_system.boardgame.Position;
import com.cperbony.chess_system.chess.pieces.King;
import com.cperbony.chess_system.chess.pieces.Rook;

public class ChessMatch {

    private Board board;
    private int turn;

    public ChessMatch() {
        board = new Board(8, 8);
        initialSetup();
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                mat[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return mat;
    }

    private void initialSetup(){
        board.placePiece(new Rook(board, Color.WHITE), new Position(2, 1));
        board.placePiece(new King(board, Color.BLACK), new Position(0, 4));
    }

}
