package boardgame;

public class Board {//tabuleiro não vai retornar a classe inteira, somente uma peça por vez
    private int rows;
    private int columns;
    private Piece[][] pieces;//matriz de peças

    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1) {//se estou fazendo um tabuleiro, a quantidade de linhas ou colunas tem que ser de pelo menos 1
            throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns]; //minhas peças serão instanciadas na quantidade de linhas e na quantidade de colunas
    }

    public int getRows() {
        return rows;
    }


    public int getColumns() {
        return columns;
    }


    public Piece piece(int row, int column) {
        if (!positionExists(row, column)) {//se essa posição não existe
            throw new BoardException("Position not on the board");
        }
        return pieces[row][column];
    }

    public Piece piece(Position position) { //sobrecarga do método anterior
        if (!positionExists(position)) {//se essa posição não existe
            throw new BoardException("Position not on the board");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position) {//vai na matriz de peças do meu tabuleiro
        if (theIsAPiece(position)) { //antes de colocar uma peça em uma posição, eu tenho que testar se já existe uma peça naquela posição, se existir, eu não posso colocar
            throw new BoardException("There is already a piece on position " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece; //nestas linhas e colunas (posição dada) e atribui a elas, a peça que eu informei
        piece.position = position; //a posição da oeça não é mais nula, ela é acessível diretamente pois ela é proteced (a classe Board é do mesmo pacote que a classe Piece)
    }

    private boolean positionExists(int row, int column) { //método auxiliar para o método abaixo, vai ter um momento que vai ser mais facil testar pela linha e pela coluna do que pela posição
        return row >= 0 && row < rows && column >= 0 && column < columns; //a condição para "quando uma posição em uma determinada linha e uma determinada coluna existe..."
        //rows - altura do tabuleiro / comuns - largura do tabuleiro
    }

    public boolean positionExists(Position position) {
        return positionExists(position.getRow(), position.getColumn()); //estou usando o método de cima
    }

    public boolean theIsAPiece(Position position) {
        if (!positionExists(position)) {// antes de testar se existe uma peça, ele testa se a posição existe
            throw new BoardException("Position not on the board");
        }
        return piece(position) != null; //se minha peça for diferente de nulo, significa que existe uma peça nesta posição
    }
}
