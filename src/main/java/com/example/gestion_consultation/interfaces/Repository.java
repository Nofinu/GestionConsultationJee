package com.example.gestion_consultation.interfaces;

import java.util.List;

public interface Repository<T> {

    void start();
    void end();

    boolean create(T o);

    boolean update(T o);

    boolean delete(T o);

    T findById(int id);

    List<T> findAll ();
}
