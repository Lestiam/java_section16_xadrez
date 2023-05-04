package boardgame;

public abstract class Piece { //não é a posição do xadrez, é uma posição simples de matriz, por isso é protected
    protected Position position;
    private Board board;

    public Piece(Board board) { //vou passar apenas o tabuleiro pois a posição de uma peça recem criada vai ser inicialmente nula, dizendo que essa peça não foi colocada no tabuleiro ainda
        this.board = board;
        position = null;
    }

    protected Board getBoard() { //somente classes do mesmo pacote e subclasses poderão acessar o tabuleiro de uma peça
        return board;              //eu não quero que o tabuleiro seja acessível pela camada de xadrez
    }

    public abstract boolean[][] possibleMoves();

    public boolean possibleMove(Position position) { //padrão de projeto que tem esse nome: Template Method. Isso só funciona quando tem uma classe concreta que implementa uma operação abstrata
        return possibleMoves()[position.getRow()][position.getColumn()]; //é chamado de rook methods, é um método que faz um gancho com a subclasse, é uma implementação padrão de um método que depende de um método abstrato
    }

    public boolean isThereAnyPossibleMove() {//me conta se existe pelo menos um movimento possível para esta peça. é util para ver se a peça está travada (sem possível movimento)
        boolean[][] mat = possibleMoves(); //mais um exemplo de implementação concreta que depende de um método abstrato
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) { //é j.lenght tambem pois estou presumindo que a matriz do xadrez é quadradada
                if (mat[i][j]) {//se a minha matriz na linha i, coluna j é verdadeira, eu assumo que existe um movimento possível
                    return true;
                }
            }
        }
        return false; //a matriz do meu tabuleiro vai dar falso em todos os lugares que a peça não puder se movimentar e vai dar verdadeiro em todos os lugares que ela PUDER se movimentar. Em suma, se esta peça não tiver nenhuma posição que seja verdadeira, significa que ela não pode se mover para lugar nenhum
    }
}
