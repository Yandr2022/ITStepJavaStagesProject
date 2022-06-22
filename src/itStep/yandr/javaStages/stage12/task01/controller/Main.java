package itStep.yandr.javaStages.stage12.task01.controller;

import itStep.yandr.javaStages.stage12.task01.model.logic.ChessPiecesLogic;
import itStep.yandr.javaStages.stage12.task01.view.Printer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Printer.print("Input 4 numbers: ");
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        boolean result = ChessPiecesLogic.chessRockStep(x1,y1,x2,y2);
        String msg = result ? "Yes" : "No";
        Printer.print(msg);

    }
}
