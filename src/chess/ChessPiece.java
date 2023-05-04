package chess;

import boardgame.Board;
import boardgame.Piece;

public abstract class ChessPiece extends Piece { //peças de xadrez, ela se tornou abstrata pois herda da classe Piece, que possui um método abstrato
    private Color color;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {//a cor de uma peça só pode ser modificada, ela não pode ser acessada
        return color;
    }

}
