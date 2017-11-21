package Utils;

public interface Observable {
    void add(Observer o);

    void notifier();
}
