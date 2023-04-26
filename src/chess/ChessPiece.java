package chess;

import boardgame.Board;
import boardgame.Piece;

public class ChessPiece extends Piece { //peças de xadrez
    private Color color;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {//a cor de uma peça só pode ser modificada, ela não pode ser acessada
        return color;
    }

}
