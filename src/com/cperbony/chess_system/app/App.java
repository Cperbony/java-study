package com.cperbony.chess_system.app;

import com.cperbony.chess_system.chess.ChessMatch;

import static com.cperbony.chess_system.app.UI.printBoard;

public class App {

    public static void main(String[] args) {

        //Board board = new Board(8,8);
        ChessMatch chessMatch = new ChessMatch();
        printBoard(chessMatch.getPieces());
    }
}


