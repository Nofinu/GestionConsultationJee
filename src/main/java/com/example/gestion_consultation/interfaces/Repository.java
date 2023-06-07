package com.example.gestion_consultation.interfaces;

import jdk.jshell.spi.ExecutionControl;

import java.util.List;

public interface Repository<T> {

    void end() throws ExecutionControl.NotImplementedException;

    boolean create(T o) throws ExecutionControl.NotImplementedException;

    boolean update(T o)throws ExecutionControl.NotImplementedException;

    boolean delete(T o) throws ExecutionControl.NotImplementedException;

    T findById(int id) throws ExecutionControl.NotImplementedException;

    List<T> findAll () throws ExecutionControl.NotImplementedException;
}
