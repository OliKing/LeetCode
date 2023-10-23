package com.oliking.codejava.test;

import org.springframework.expression.spel.ast.ConstructorReference;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class M {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {

        Class clazz = Class.forName("com.oliking.codejava.test.A");
        Constructor constructor = clazz.getDeclaredConstructor(int.class);
        constructor.setAccessible(true);
        A a = (A) constructor.newInstance(12);
        System.out.println(a.getA());
        Field f = clazz.getDeclaredField("a");
        f.setAccessible(true);
        f.set(a, 13);
        System.out.println(a.getA());
    }
}
