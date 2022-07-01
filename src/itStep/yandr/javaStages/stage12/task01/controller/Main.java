package itStep.yandr.javaStages.stage12.task01.controller;

import itStep.yandr.javaStages.stage12.task01.model.logic.ChessPiecesLogic;
import itStep.yandr.javaStages.stage12.task01.view.Printer;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public  static final String MSG_SAME_POINTS = "The coordinates of chessboard square 1 " +
            "and chessboard square 2 must be different";
    public  static final String MSG_OUT_OF_BOUND = "The coordinates are outside the chessboard";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Printer.print("Input 4 numbers: ");
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        boolean result;
        try {
            result = ChessPiecesLogic.checkRookMove(x1,y1,x2,y2);
            String msg = result ? "Yes" : "No";
            Printer.print("Rook: "+ msg);
        } catch (IOException e) {
            Printer.printError(MSG_SAME_POINTS);
        }catch (IndexOutOfBoundsException e){
            Printer.printError(MSG_OUT_OF_BOUND);
        }


    }
}
