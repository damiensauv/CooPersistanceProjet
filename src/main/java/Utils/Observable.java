package Utils;

public interface Observable {
    void add(Observeur o);

    void notifier();
}
