package com.dormitory.service;

public interface GetService<T, P> {
public T get(P id);
public P getLastInsertId();
}
