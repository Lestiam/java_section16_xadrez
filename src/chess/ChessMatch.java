package chess;

import boardgame.Board;

public class ChessMatch {//partida de xadrez, é o coração do sistema de xadrez

    private Board board; //uma partida de xadrez precisa ter um tabuleiro

    public ChessMatch() {
        board = new Board(8,8); //quem tem que saber a dimensão de um tabuleiro de xadrez, é a classe ChessMatch
    }

    public ChessPiece[][] getpieces() { //retorna uma matriz de peças de xadrez orrespondentes a essa partida
        ChessPiece [][] mat = new ChessPiece[board.getRows()][board.getColumns()];//variavel auxiliar
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) { //para cada posição i/j do meu tabuleiro, eu vou fazer com
                mat[i][j] = (ChessPiece) board.piece(i, j); //que a minha matriz mat na linha i coluna j, receba o board.piece nas devidas posições
            }
        }
        return mat; //retorna a matriz de peças da minha partida de xadrez
        //vou percorrer a matriz de peças do board e para cada peça do meu tabuleiro, eu vou fazer um
        //downcasting para chessPiece
    }
}
