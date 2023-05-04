package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece { //torre
    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "R"; //R de Rook
    }

    @Override
    public boolean[][] possibleMoves() { //por padrão um boolean retorna falso, então é como se esta torre estivesse presa
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];//pega o tamanho da matriz

        Position p = new Position(0,0); //variavel auxiliar só para ter uma posição inicial

        //verifico acima da minha peça
        p.setValues(position.getRow() - 1, position.getColumn()); // o -1 quer dizer que uma linha acima da minha peça e na mesma coluna da minha peça. O position é o atributo Position da classe peça, quer dizer que estou acessando a posição da própria peça
        while (getBoard().positionExists(p) && !getBoard().theIsAPiece(p)) { //enquanto a posição p existir e não tiver uma peça lá... Ou seja, enquanto esta posição estiver vaga, eu à marco como verdadeira
            mat[p.getRow()][p.getColumn()] = true; //marquei como verdadeira a posição da matriz, indicando que a minha peça pode mover para lá
            p.setRow(p.getRow() -1); //enquanto foi verdadeiro o while, setto a linha uma casa acima
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) { //eu digo que se existe uma peça lá e ela é do oponente, eu poço me mover para aquela posição (pego a peça do oponente)
            mat[p.getRow()][p.getColumn()] = true;
        }

        //verifico a esquerda da minha peça
        p.setValues(position.getRow(), position.getColumn() -1); // agora estou analisando na mesma linha e uma coluna a esquerda da minha peça
        while (getBoard().positionExists(p) && !getBoard().theIsAPiece(p)) { //enquanto a posição p existir e não tiver uma peça lá... Ou seja, enquanto esta posição estiver vaga, eu à marco como verdadeira
            mat[p.getRow()][p.getColumn()] = true; //marquei como verdadeira a posição da matriz, indicando que a minha peça pode mover para lá
            p.setColumn(p.getColumn() -1); //enquanto foi verdadeiro o while, setto a coluna uma casa a esquerda
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) { //eu digo que se existe uma peça lá e ela é do oponente, eu poço me mover para aquela posição (pego a peça do oponente)
            mat[p.getRow()][p.getColumn()] = true;
        }

        //verifico a direita da minha peça
        p.setValues(position.getRow(), position.getColumn() +1); // agora estou analisando na mesma linha e uma coluna a direita da minha peça
        while (getBoard().positionExists(p) && !getBoard().theIsAPiece(p)) { //enquanto a posição p existir e não tiver uma peça lá... Ou seja, enquanto esta posição estiver vaga, eu à marco como verdadeira
            mat[p.getRow()][p.getColumn()] = true; //marquei como verdadeira a posição da matriz, indicando que a minha peça pode mover para lá
            p.setColumn(p.getColumn() -1); //enquanto foi verdadeiro o while, setto a coluna uma casa a direita
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) { //eu digo que se existe uma peça lá e ela é do oponente, eu poço me mover para aquela posição (pego a peça do oponente)
            mat[p.getRow()][p.getColumn()] = true;
        }

        //verifico abaixo da minha peça
        p.setValues(position.getRow() + 1, position.getColumn()); // agora estou analisando na mesma coluna e uma linha abaixo
        while (getBoard().positionExists(p) && !getBoard().theIsAPiece(p)) { //enquanto a posição p existir e não tiver uma peça lá... Ou seja, enquanto esta posição estiver vaga, eu à marco como verdadeira
            mat[p.getRow()][p.getColumn()] = true; //marquei como verdadeira a posição da matriz, indicando que a minha peça pode mover para lá
            p.setRow(p.getRow() + 1); //enquanto foi verdadeiro o while, setto a linha uma casa abaixo
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) { //eu digo que se existe uma peça lá e ela é do oponente, eu poço me mover para aquela posição (pego a peça do oponente)
            mat[p.getRow()][p.getColumn()] = true;
        }

        return mat;
    }
}
