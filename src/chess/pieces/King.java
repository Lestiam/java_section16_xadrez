package chess.pieces;

import boardgame.Board;
import boardgame.Position;
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

    private boolean canMove(Position position) {//esse método vai me dizer se o rei pode mover para um determinada posição
        ChessPiece p = (ChessPiece)getBoard().piece(position); //pego a peça p do board nesta posição
        return p == null || p.getColor() != getColor(); //p igual a nulo, ou seja, a casa esta vazia ou a cor da minha peça p != da cor dela mesma, ou seja, posso pegar a peça do adversario
    }

    @Override
    public boolean[][] possibleMoves() { //por padrão um boolean retorna falso, então é como se este rei estivesse preso
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];//pega o tamanho da matriz

        Position p = new Position(0,0);

        //acima
        p.setValues(position.getRow() -1, position.getColumn()); // posição acima do rei
        if (getBoard().positionExists(p) && canMove(p)) { //se a posição para a qual ele quer mover existe e se ele pode se mover para ela
            mat[p.getRow()][p.getColumn()] = true;
        }

        //abaixo
        p.setValues(position.getRow() +1, position.getColumn()); // posição abaixo do rei
        if (getBoard().positionExists(p) && canMove(p)) { //se a posição para a qual ele quer mover existe e se ele pode se mover para ela
            mat[p.getRow()][p.getColumn()] = true;
        }

        //esquerda
        p.setValues(position.getRow(), position.getColumn() - 1); // posição a esquerda do rei
        if (getBoard().positionExists(p) && canMove(p)) { //se a posição para a qual ele quer mover existe e se ele pode se mover para ela
            mat[p.getRow()][p.getColumn()] = true;
        }

        //direita
        p.setValues(position.getRow(), position.getColumn() + 1); // posição a direita do rei
        if (getBoard().positionExists(p) && canMove(p)) { //se a posição para a qual ele quer mover existe e se ele pode se mover para ela
            mat[p.getRow()][p.getColumn()] = true;
        }

        //posição noroeste(acime e a esquerda)
        p.setValues(position.getRow() - 1, position.getColumn() - 1); // posição a noroeste do rei
        if (getBoard().positionExists(p) && canMove(p)) { //se a posição para a qual ele quer mover existe e se ele pode se mover para ela
            mat[p.getRow()][p.getColumn()] = true;
        }

        //posição nordeste(acime e a direita)
        p.setValues(position.getRow() - 1, position.getColumn() + 1); // posição a nordeste do rei
        if (getBoard().positionExists(p) && canMove(p)) { //se a posição para a qual ele quer mover existe e se ele pode se mover para ela
            mat[p.getRow()][p.getColumn()] = true;
        }

        //posição sudoeste(abaixo e a esquerda)
        p.setValues(position.getRow() + 1, position.getColumn() - 1); // posição a sudoeste do rei
        if (getBoard().positionExists(p) && canMove(p)) { //se a posição para a qual ele quer mover existe e se ele pode se mover para ela
            mat[p.getRow()][p.getColumn()] = true;
        }

        //posição sudeste(abaixo e a direita)
        p.setValues(position.getRow() + 1, position.getColumn() + 1); // posição a sudeste do rei
        if (getBoard().positionExists(p) && canMove(p)) { //se a posição para a qual ele quer mover existe e se ele pode se mover para ela
            mat[p.getRow()][p.getColumn()] = true;
        }

        return mat;
    }
}
