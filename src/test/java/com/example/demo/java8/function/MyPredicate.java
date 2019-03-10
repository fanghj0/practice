package com.example.demo.java8.function;

/**
 * 断言接口
 * @param <T>
 */
public interface MyPredicate<T> {

    boolean test(T t);
}
