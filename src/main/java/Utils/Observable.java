package Utils;

public interface Observable {
    void add(Observer o);
    void notify(Observer o);
}
