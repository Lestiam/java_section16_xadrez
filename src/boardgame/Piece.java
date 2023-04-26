package boardgame;

public class Piece { //não é a posição do xadrez, é uma posição simples de matriz, por isso é protected
    protected  Position position;
    private Board board;

    public Piece(Board board) { //vou passar apenas o tabuleiro pois a posição de uma peça recem criada vai ser inicialmente nula, dizendo que essa peça não foi colocada no tabuleiro ainda
        this.board = board;
        position = null;
    }

    protected Board getBoard() { //somente classes do mesmo pacote e subclasses poderão acessar o tabuleiro de uma peça
        return board;              //eu não quero que o tabuleiro seja acessível pela camada de xadrez
    }

}
