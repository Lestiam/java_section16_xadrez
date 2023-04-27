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

    public Piece piece(int row, int column) {
        return pieces[row][column];
    }
    public Piece piece(Position position) { //sobrecarga do método anterior
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position) {//vai na matriz de peças do meu tabuleiro
        pieces[position.getRow()][position.getColumn()] = piece; //nestas linhas e colunas (posição dada) e atribui a elas, a peça que eu informei
        piece.position = position; //a posição da oeça não é mais nula, ela é acessível diretamente pois ela é proteced (a classe Board é do mesmo pacote que a classe Piece)
    }
}
