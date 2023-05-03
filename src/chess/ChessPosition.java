package chess;

import boardgame.Position;

public class ChessPosition {
    private char column;
    private int row;

    public ChessPosition(char column, int row) {
        if (column < 'a' || column > 'h' || row < 1 || row > 8) {//o if tambem aceita caracteres , minhas colunas vão de a até h e as linhas de 1 a 8
            throw new ChessException("Error instantiating ChessPosition. Valid values are from a1 to h8.");
        }
        this.column = column;
        this.row = row;
    }

    public char getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    protected Position toPosition() { //converte a posição desta classe para a posição "normal" da matriz
        // a formula da linha da matriz é 8 menos a linha do xadrez: matriz_row = 8 - chess_row
        // a formula da coluna da matriz é a coluna do xadrez subtraído do carctere 'a', pois o caractere a esta na posição 0, o b na 1...: matriz_column = chess_column - 'a'

        return new Position(8 - row, column - 'a');
    }

    protected static ChessPosition fromPosition(Position position) {//dada uma posição na matriz eu converto para uma posição no xadres, seria a operação inversa do método de cima
        return new ChessPosition((char) ('a' - position.getColumn()), 8 - position.getRow());
    }

    @Override
    public String toString() {
        return "" + column + row; //o string vazio é para forçar o compilador a entender que isto é uma concatenação de Strings, se não ele vai achar que é uma soma de ints
    }
}
