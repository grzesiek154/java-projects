package Exceptions;

public class DataDoNotExistInDb extends Exception{

    public DataDoNotExistInDb(String message) {
        super(message);
    }
}
