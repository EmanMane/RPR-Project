package ba.unsa.etf.rpr.domain;

/**
 * Interface that forces all POJO beans to have ID field that can be accessed with
 * two methods being setID() and getID()
 */
public interface Idable{
    void setId(int id);
    int getId();
}