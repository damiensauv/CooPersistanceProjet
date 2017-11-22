package Persistance.UOW;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;


public class VirtualProxyGenerique {

    public static class VirtualProxyBuilder<T> implements InvocationHandler {

        T realObject = null;

        Factory<T> factory;

        Class<?> iface;

        public VirtualProxyBuilder(Class<?> iface, Factory<T> factory) {
            this.iface = iface;
            this.factory = factory;
        }

        public T getProxy() {
            @SuppressWarnings("unchecked")
            T r  = (T) Proxy.newProxyInstance(iface.getClassLoader(), new Class<?>[] { iface }, this);
            System.out.println("PROXY: On a cree le virtual proxy!");
            return r;
        }

        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("PROXY: On a appelle la methode " + method.getName() + " sur le virtual proxy!");
            if (realObject == null) {
                System.out.println("PROXY: On initialise l'objet proxyfié maintenant");
                realObject = factory.create();
            }
            System.out.println("PROXY: On appelle la methode sur l'objet reel.");
            return method.invoke(realObject, args);
        }
    }

    public class NumFactory implements Factory<List<Integer> > {
        public List<Integer> create() {
            ArrayList<Integer> al = new ArrayList<Integer>();
            al.add(1);
            al.add(2);
            al.add(3);
            return al;
        }
    }

}