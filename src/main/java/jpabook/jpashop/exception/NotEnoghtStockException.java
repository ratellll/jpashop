package jpabook.jpashop.exception;

public class NotEnoghtStockException extends RuntimeException {

    public NotEnoghtStockException() {
        super();
    }

    public NotEnoghtStockException(String message) {
        super(message);
    }

    public NotEnoghtStockException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnoghtStockException(Throwable cause) {
        super(cause);
    }

}
