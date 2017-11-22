package Persistance.Mapper;

import java.sql.SQLException;

public abstract class DataMapper<T> {

    public DataMapper() {
    }

    abstract T find(Integer id);

    abstract void update(T o) throws SQLException;
}