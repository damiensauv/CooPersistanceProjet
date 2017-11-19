package Utils;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

class IdentityMap<T> {
    private Map<String, WeakReference<T>> map;

    IdentityMap() {
        map = new HashMap<String, WeakReference<T>>();
    }

    void delete(String id) {
        map.remove(id);
    }

    public T get(String id) {
        WeakReference<T> ref = map.get(id);
        if (ref == null)
            return null;

        T obj = ref.get();
        if (obj == null) {
            map.remove(id);
        }
        return obj;
    }

    void put(String id, T obj) {
        map.put(id, new WeakReference<T>(obj));
    }

}