package itStep.yandr.javaStages.stage12.task01.util;

import itStep.yandr.javaStages.stage12.task01.exception.InvalidSizeOfArray;

import java.io.IOException;

import static itStep.yandr.javaStages.stage12.task01.model.logic.SelectionChessPiecesLogic.AMOUNT_CHESS_PIECES;

public class MSGBuilder {
    private static final String ROOK_NAME = "Rook";
    private static final String KING_NAME = "King";
    private static final String BISHOP_NAME = "Bishop";
    private static final String QUEEN_NAME = "Queen";
    private static final String KNIGHT_NAME = "Knight";

    public static String buildMSGtoResultForAllChessPieces(boolean[] results) throws InvalidSizeOfArray {
        if(results==null||results.length<AMOUNT_CHESS_PIECES||results.length>AMOUNT_CHESS_PIECES){
            throw new InvalidSizeOfArray();
        }
        String[] NamesChessPieces = {ROOK_NAME, KING_NAME, BISHOP_NAME, QUEEN_NAME, KNIGHT_NAME};
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < NamesChessPieces.length - 1; i++) {
            builder.append(NamesChessPieces[i] + " : ").append(results[i] ? "Yes\n" : "No\n");
        }
        return builder + "";
    }

    public static String buildMSGtoResultForOneFromChessPieces(String name, boolean result) throws IOException {
        if (name == null) {
            throw new IOException();
        }
        StringBuilder builder = new StringBuilder(name.substring(0,1).toUpperCase());
        builder.append(name.substring(1).toLowerCase());
        return String.format("%s : %s", builder+"", result ? "Yes" : "No");
    }

}
