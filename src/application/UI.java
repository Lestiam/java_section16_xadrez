package application;

import chess.ChessPiece;

public class UI { //User Interface

    public static void printBoard(ChessPiece[][] pieces) { //recebe a matriz de peças da minha partida
        for (int i = 0; i < pieces.length; i++) {
            System.out.print((8 - i) + " "); //para imprimir o número na frente
            for (int j = 0; j < pieces.length; j++) {
                printPiece(pieces[i][j]); //imprime a peça
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }


    private static void printPiece(ChessPiece piece) {
        if (piece == null) { //significa que não tinha peça naquela posição do tabuleiro
            System.out.print("-");
        } else {
            System.out.print(piece); //imprimo a peça
        }
        System.out.print(" "); //espaço para que as peças não fiquem grudadas umas nas outras
    }
}
