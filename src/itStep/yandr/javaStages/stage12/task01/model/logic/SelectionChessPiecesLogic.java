package itStep.yandr.javaStages.stage12.task01.model.logic;

import itStep.yandr.javaStages.stage12.task01.exception.OutOfRangeValueException;
import itStep.yandr.javaStages.stage12.task01.exception.SameCoordinatesException;
import itStep.yandr.javaStages.stage12.task01.view.Printer;

import java.io.IOException;


public class SelectionChessPiecesLogic {
    private static final String ROOK_NAME = "rook";
    private static final String KING_NAME = "king";
    private static final String BISHOP_NAME = "bishop";
    private static final String QUEEN_NAME = "queen";
    private static final String KNIGHT_NAME = "knight";
    public static final int AMOUNT_CHESS_PIECES = 5;
    public static final String MSG_SAME_POINTS = "The coordinates of chessboard square 1 " +
            "and chessboard square 2 must be different";
    public static final String MSG_OUT_OF_BOUND = "The coordinates are outside the chessboard";
    public static final String MSG_WRONG_NAME_CHESS_PIECE = "The name of chess piece not found";

    /**
     * @return an array with the results of checking moves for chess pieces in the following sequence: Rook, King
     * , Bishop, Queen, Knight
     */
    public static boolean[] checkMoveAllChessPiece( int x1, int y1, int x2, int y2) throws SameCoordinatesException
            , OutOfRangeValueException {
        boolean [] result = new boolean[AMOUNT_CHESS_PIECES] ;
            result[0] = ChessPiecesLogic.checkRookMove(x1, y1, x2, y2);
            result[1] = ChessPiecesLogic.checkKingMove(x1, y1, x2, y2);
            result[2] = ChessPiecesLogic.checkBishopMove(x1, y1, x2, y2);
            result[3] = ChessPiecesLogic.checkQueenMove(x1, y1, x2, y2);
            result[4] = ChessPiecesLogic.checkKnightMove(x1, y1, x2, y2);
        return result;
    }

    public static boolean checkMoveChessPieceWithSelectedName(String chessPieceName, int x1, int y1, int x2, int y2)
            throws SameCoordinatesException, OutOfRangeValueException, IOException {
        boolean result;
            chessPieceName = chessPieceName.toLowerCase();
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
                    throw new IOException();
            }

        return result;

    }

}



