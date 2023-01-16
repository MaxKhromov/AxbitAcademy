package hw6.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InvocationHandlerClass implements InvocationHandler {
    Object proxied;

    public InvocationHandlerClass(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("Был вызван метод: " + method.getName() + "\n" +
                "Переданы параметры: " + Arrays.asList(args) + "\n");

        return method.invoke(proxied, args);
    }

    public static void main(String[] args) {
        var proxy = (List) Proxy.newProxyInstance(InvocationHandlerClass.class.getClassLoader(), new Class[]{List.class}, new InvocationHandlerClass(new ArrayList()));
        proxy.add("Чел");
        proxy.add("Чел2");
        proxy.remove("Чел");
        proxy.add(proxy.contains("Чел2"));
        proxy.containsAll(new ArrayList<>() {
            {
                add("Чел2");
                add(true);
            }
        });
    }
}
