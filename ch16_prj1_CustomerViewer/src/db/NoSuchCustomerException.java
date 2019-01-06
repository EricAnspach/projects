package db;

public class NoSuchCustomerException extends Exception {

    public NoSuchCustomerException() {
    }

    public NoSuchCustomerException(String s) {
        super(s);
    }
}
