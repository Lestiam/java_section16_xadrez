package boardgame;

public class BoardException extends RuntimeException{
    public BoardException(String msg) {
        super(msg); //esse construtor simplesmente repassa a mensagem para o construtor da super classe RuntimeException1
    }
}
