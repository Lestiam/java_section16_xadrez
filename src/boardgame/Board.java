package boardgame;

public class Board {//tabuleiro não vai retornar a classe inteira, somente uma peça por vez
    private int rows;
    private int columns;
    private Piece [][] pieces;//matriz de peças

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns]; //minhas peças serão instanciadas na quantidade de linhas e na quantidade de colunas
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }
}
