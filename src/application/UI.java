package application;

import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UI { //User Interface

    // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
//códigos especiais das cores para imprimirmos no console
    //cores do texto:
    public static final String ANSI_RESET = "\u001B[0m"; //reseta a cor
    public static final String ANSI_BLACK = "\u001B[30m"; //core preta...
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    //cores do fundo:
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public static ChessPosition readChessPosition(Scanner sc) { //instanciei o Scanner no programa principal e instanciei ele aqui como argumento e vou fazer a leitura desta posição neste mesmo Scanner
        try {
            String s = sc.nextLine(); //nossa posição é dada assim: a1 a2 a3
            char column = s.charAt(0);// lê a primeira posição que é a coluna
            int row = Integer.parseInt(s.substring(1)); //recorto minha String a partir da posição 1 e aí converto o resultado para inteiro, pegando a minha linha
            return new ChessPosition(column, row); //retorno uma nova posição recebendo esta coluna e esta linha
        } catch (RuntimeException e) {
            throw new InputMismatchException("Error reading ChessPosition. Valid values are from a1 to h8");
        }
    }

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
            if (piece.getColor() == Color.WHITE) { //imprimo a peça branca
                System.out.print(ANSI_WHITE + piece + ANSI_RESET);
            } else {
                System.out.print(ANSI_YELLOW + piece + ANSI_RESET); //imprimo a peça preta
            }
        }
        System.out.print(" ");
    }
}
