package ba.unsa.etf.rpr.exceptions;

public class AnimalException extends Exception{

    public AnimalException(String msg, Exception reason){
        super(msg, reason);
    }

    public AnimalException(String msg){
        super(msg);
    }
}