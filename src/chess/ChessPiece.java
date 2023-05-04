package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece { //peças de xadrez, ela se tornou abstrata pois herda da classe Piece, que possui um método abstrato
    private Color color;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {//a cor de uma peça só pode ser modificada, ela não pode ser acessada
        return color;
    }

//é protected para ser acessivel somente pelas subclasses e pelas peças
    protected boolean isThereOpponentPiece(Position position) {//existe alguma peça do adversária em uma dada posição? Porque se a peça for adversaria eu ainda poderei mover para aquela casa e poderei capturar aquela peça
       //esta operação ficou na classe generica pois ela vai ser reaproveitada em todas as peças
        ChessPiece p = (ChessPiece) getBoard().piece(position); //pego a peça que estava naquela posição
        return  p != null && p.getColor() != color; //testo se a posição daquela peça é diferente de nulo e se ela é diferente da cor das minhas peças, ou seja, uma peça adversária
    }

}
