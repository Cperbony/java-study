package com.cperbony.chess_system.app;

import com.cperbony.chess_system.chess.ChessMatch;
import com.cperbony.chess_system.chess.ChessPiece;
import com.cperbony.chess_system.chess.ChessPosition;

import java.util.Scanner;

import static com.cperbony.chess_system.app.UI.printBoard;
import static com.cperbony.chess_system.app.UI.readChessPosition;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();

        while (true) {
            printBoard(chessMatch.getPieces());
            System.out.println();
            System.out.print("Source: ");
            ChessPosition source = readChessPosition(scanner);

            System.out.println();
            System.out.print("Target: ");
            ChessPosition target = readChessPosition(scanner);

            ChessPiece capturedPiece = chessMatch.performChessMove(source, target);

        }

    }
}


