package itStep.yandr.javaStages.stage12.task01.controller;

import itStep.yandr.javaStages.stage12.task01.model.logic.SelectionChessPiecesLogic;
import itStep.yandr.javaStages.stage12.task01.util.InputManager;
import itStep.yandr.javaStages.stage12.task01.view.Printer;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static final String MSG_SAME_POINTS = "The coordinates of chessboard square 1 " +
            "and chessboard square 2 must be different";
    public static final String MSG_OUT_OF_BOUND = "The coordinates are outside the chessboard";
    public static final String MSG_WRONG_NAME_CHESS_PIECE = "The name of chess piece not found";


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Printer.print("Input the starting position of the chess piece\nNumber of the checkerboard row: ");
        int x1 = InputManager.getInt();
        Printer.print("Number of the checkerboard column: ");
        int y1 = InputManager.getInt();
        Printer.print("Input the position of the chess piece to check\nNumber of the checkerboard row: ");
        int x2 = InputManager.getInt();
        Printer.print("Number of the checkerboard column: ");
        int y2 = InputManager.getInt();
        Printer.print("Input the name of the chess piece you want to check (rook, king, bishop, queen, knight): ");
        String chessPiece = InputManager.getStringWithLetter();
        boolean result;
        try {
            result = SelectionChessPiecesLogic.checkMoveChessPieceWithSelected(chessPiece,x1, y1, x2, y2);
            Printer.print(result?"Yes":"No");
//            result = ChessPiecesLogic.checkRookMove(x1, y1, x2, y2);
//            String msg = result ? "Yes" : "No";
//            Printer.print("\nRook: " + msg);
//            result = ChessPiecesLogic.checkKingMove(x1, y1, x2, y2);
//            msg = result ? "Yes" : "No";
//            Printer.print("\nKing: " + msg);
//            result = ChessPiecesLogic.checkBishopMove(x1, y1, x2, y2);
//            msg = result ? "Yes" : "No";
//            Printer.print("\nBishop: " + msg);
//            result = ChessPiecesLogic.checkQueenMove(x1, y1, x2, y2);
//            msg = result ? "Yes" : "No";
//            Printer.print("\nQueen: " + msg);
//            result = ChessPiecesLogic.checkKnightMove(x1, y1, x2, y2);
//            msg = result ? "Yes" : "No";
//            Printer.print("\nKnight: " + msg);
        } catch (IOException e) {
            Printer.printError(MSG_SAME_POINTS);
        } catch (IndexOutOfBoundsException e) {
            Printer.printError(MSG_OUT_OF_BOUND);
        } catch (IllegalArgumentException e) {
            Printer.printError(MSG_WRONG_NAME_CHESS_PIECE);
        }
    }
}




