package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K"; //K de king
    }

    @Override
    public boolean[][] possibleMoves() { //por padrão um boolean retorna falso, então é como se este rei estivesse preso
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];//pega o tamanho da matriz
        return mat;
    }
}
