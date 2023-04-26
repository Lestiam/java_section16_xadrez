package boardgame;

public class Position { //classe da camada de tabuleiro, representa uma posicao no tabuleiro
    private int row;
    private int column;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public String toString() { //vai imprimir a linha e a coluna
        return  row + ", " + column;
    }
}
