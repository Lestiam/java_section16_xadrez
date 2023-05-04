package application;

import boardgame.Board;
import boardgame.Position;
import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();

        while (true) {
            try {
                UI.clearScreen();
                UI.printBoard(chessMatch.getpieces());
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(sc); //passo o scanner para a posição

                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(chessMatch.getpieces(), possibleMoves); //sobrecarga do método printBoard que passa os movimentos possíveis. Agora ele tambem vai ser responsável por imprimir o tabuleiro só que colorindo as posições possiveis para onde minha peça pode mover
                //feito isso, aí sim eu vou pedir para o usuário entrar com a posição de destino
                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(sc);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target); //movo da origem para o destino
            }catch (ChessException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
    }
}