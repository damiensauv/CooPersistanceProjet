package Persistance.Mapper;

public abstract class DataMapper<T> {

    public DataMapper() {
    }

    abstract T find(Integer id);

    abstract void insert(T o);

    abstract void delete(T o);

    abstract void update(T o);
}