package itStep.yandr.javaStages.stage12.task01.model.logic;

import java.io.IOException;


public class SelectionChessPiecesLogic {
    private static final String ROOK_NAME = "rook";
    private static final String KING_NAME = "king";
    private static final String BISHOP_NAME = "bishop";
    private static final String QUEEN_NAME = "queen";
    private static final String KNIGHT_NAME = "knight";

    public static boolean checkMoveChessPieceWithSelected(String chessPieceName, int x1, int y1, int x2, int y2)
            throws IOException {
        chessPieceName = chessPieceName.toLowerCase();
        boolean result;
        switch (chessPieceName) {
            case ROOK_NAME:
                result = ChessPiecesLogic.checkRookMove(x1, y1, x2, y2);
                break;
            case KING_NAME:
                result = ChessPiecesLogic.checkKingMove(x1, y1, x2, y2);
                break;
            case BISHOP_NAME:
                result = ChessPiecesLogic.checkBishopMove(x1, y1, x2, y2);
                break;
            case QUEEN_NAME:
                result = ChessPiecesLogic.checkQueenMove(x1, y1, x2, y2);
                break;
            case KNIGHT_NAME:
                result = ChessPiecesLogic.checkKnightMove(x1, y1, x2, y2);
                break;
            default:
                throw new IllegalArgumentException();
        }
        return result;

    }

}



