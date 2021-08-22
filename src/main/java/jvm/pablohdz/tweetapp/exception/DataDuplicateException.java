package jvm.pablohdz.tweetapp.exception;

public class DataDuplicateException extends RuntimeException{
    public DataDuplicateException(String data) {
        super("The data: " + data + " is duplicated, data must be unique");
    }
}
