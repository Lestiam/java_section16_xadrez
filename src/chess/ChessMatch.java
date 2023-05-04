package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {//partida de xadrez, é o coração do sistema de xadrez

    private Board board; //uma partida de xadrez precisa ter um tabuleiro

    public ChessMatch() {
        board = new Board(8, 8); //quem tem que saber a dimensão de um tabuleiro de xadrez, é a classe ChessMatch
        initialSetup(); //chama o inicio da partida aqui no construtor
    }

    public ChessPiece[][] getpieces() { //retorna uma matriz de peças de xadrez orrespondentes a essa partida
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];//variavel auxiliar
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) { //para cada posição i/j do meu tabuleiro, eu vou fazer com
                mat[i][j] = (ChessPiece) board.piece(i, j); //que a minha matriz mat na linha i coluna j, receba o board.piece nas devidas posições
            }
        }
        return mat; //retorna a matriz de peças da minha partida de xadrez
        //vou percorrer a matriz de peças do board e para cada peça do meu tabuleiro, eu vou fazer um
        //downcasting para chessPiece
    }

    public boolean[][] possibleMoves(ChessPosition sourcePosition) { //isto é para que eu possa imprimir na minha aplicação as posições possíveis à partir de uma posição de origem
        Position position = sourcePosition.toPosition(); //transformo a posição de xadrez em uma posição de matriz normal
        validateSourcePosition(position); //valido a posição assim que o usuário entrar com ela
        return board.piece(position).possibleMoves(); //retorno os movimentos possiveis da peça nesta posição
    }

    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
        Position source = sourcePosition.toPosition(); //primeiro converto estas duas posições para posições da matriz
        Position target = targetPosition.toPosition();
        validateSourcePosition(source); //esta operação é responsável por validar esta posição de origem, caso ela não exista, esta operação vai lancar uma excessão
        validateTargetPosition(source, target); //agora estou validando a posição de destino
        Piece capturedPiece = makeMove(source, target); //esta variavel recebe o resultado da operação makeMove que realize o movimento da peça
        return (ChessPiece) capturedPiece; //retorno minha peça capturada, fazendo um downcasting para ChessPiece pois a peça capturada é do tipo Piece
    }

    private Piece makeMove(Position source, Position target) { //recebe uma posição de origem e uma de destino
        Piece p = board.removePiece(source); //retirei a peça da posição de origem
        Piece capturedPiece = board.removePiece(target); //removo a possível peça que esteja na posição de destino e ela por padrão, será a peça capturada
        board.placePiece(p, target); //coloco a peça que estava na posição de origem, no lugar da peça que estava na posição de destino
        return capturedPiece;
    }

    private void validateSourcePosition(Position position) {
        if (!board.theIsAPiece(position)) { //neguei o thereIsAPiece, ou seja, se não existir uma peça nesta posição, eu dou uma excessão
            throw  new ChessException("There is no piece on source position"); //a minha ChessException também é uma BoardException
        }
        if (!board.piece(position).isThereAnyPossibleMove()) { //testo se existe movimentos possíveis para a peça, acesso meu tabuleito.acesso minha peça na posição de origem e a apartir desta posição, eu vou testar se tem algum movimento possível....
            throw new ChessException("There is no possible moves for the chosen piece");// mas como eu neguei o if eu estou perguntando se não tem nenhum movimento possível e se não tiver, eu lanço uma excessão
        }
    }

    private void validateTargetPosition(Position source, Position target) { //como eu faço se a posição de destino é um movimento possível em relação a peça de origem?
        //...Basta testar se essa posição de destino (target) é um movimento possível em relação a peça que estiver na posição de origem (source) (ex: se é o rei na posição origem, testa os movimentos do rei, e assim por diante)
        if (!board.piece(source).possibleMove(target)) { //se para a peça de origem, a posição de destino NÃO é um movimento possível, significa que eu não posso me mexer para lá
            throw  new ChessException("The chosen piece can't move to target position");
        }
    }

    private void placeNewPiece(char column, int row, ChessPiece piece) {//recebe as coordenadas do xadrez
        board.placePiece(piece, new ChessPosition(column, row).toPosition()); //o toPosition converte para a posição de matriz
    }

    private void initialSetup() {
        //board.placePiece(new Rook(board, Color.WHITE), new Position(2, 1)); //o Position é la da camada de board, não da camada de xadrez
        //era assim antes, agora eu vou passar a posição do xadrez:
        placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
    }
}
