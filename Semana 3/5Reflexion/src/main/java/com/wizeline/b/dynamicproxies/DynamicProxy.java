package com.wizeline.b.dynamicproxies;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class DynamicProxy {
    public static void main(String[] args) {
        Map mapProxyInstance = (Map) Proxy.newProxyInstance(
                DynamicProxy.class.getClassLoader(), new Class[] {Map.class},
                new TimingDynamicInvocationHandler(new HashMap<>()));

        mapProxyInstance.put("hello", "world");
        mapProxyInstance.get("hello");
    }
}
