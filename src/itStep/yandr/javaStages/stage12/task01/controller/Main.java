package itStep.yandr.javaStages.stage12.task01.controller;

import itStep.yandr.javaStages.stage12.task01.exception.InvalidSizeOfArray;
import itStep.yandr.javaStages.stage12.task01.exception.OutOfRangeValueException;
import itStep.yandr.javaStages.stage12.task01.exception.SameCoordinatesException;
import itStep.yandr.javaStages.stage12.task01.model.logic.SelectionChessPiecesLogic;
import itStep.yandr.javaStages.stage12.task01.util.InputManager;
import itStep.yandr.javaStages.stage12.task01.util.MSGBuilder;
import itStep.yandr.javaStages.stage12.task01.view.Printer;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static final String MSG_WRONG_DATA = "Entered data is not valid\n";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Printer.print("Input the starting position of the chess piece\nNumber of the checkerboard row: ");
        int x1 = InputManager.getInt();
        Printer.print("Number of the checkerboard column: ");
        int y1 = InputManager.getInt();
        Printer.print("\nInput the position of the chess piece to check\nNumber of the checkerboard row: ");
        int x2 = InputManager.getInt();
        Printer.print("Number of the checkerboard column: ");
        int y2 = InputManager.getInt();
        Printer.print("If you want to check the possibility of a move for one piece - enter the word one" +
                ", if for all - enter the word all\n");
        String choice = InputManager.getStringWithLetter();
        choice.toLowerCase();
        String msg;
        try {
            switch (choice) {
                case "all":
                    boolean[] results = SelectionChessPiecesLogic.checkMoveAllChessPiece(x1, y1, x2, y2);
                    msg = MSGBuilder.buildMSGtoResultForAllChessPieces(results);
                    break;
                case "one":
                    Printer.print("Input the name of the chess piece you want to check (rook, king, bishop, queen, knight): ");
                    String chessPiece = InputManager.getStringWithLetter();
                    boolean result = SelectionChessPiecesLogic.checkMoveChessPieceWithSelectedName
                            (chessPiece, x1, y1, x2, y2);
                    msg = MSGBuilder.buildMSGtoResultForOneFromChessPieces(chessPiece, result);
                    break;
                default:
                    throw new IOException();
            }
            Printer.print(msg);
        } catch (SameCoordinatesException e) {
            e.printStackTrace();
        } catch (OutOfRangeValueException e) {
            e.printStackTrace();
        } catch (IOException e) {
            Printer.printError(MSG_WRONG_DATA);
            e.printStackTrace();
        } catch (InvalidSizeOfArray e) {
            e.printStackTrace();
        }
        scanner.close();
    }

}





