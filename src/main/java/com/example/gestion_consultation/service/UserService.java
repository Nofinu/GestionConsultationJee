package com.example.gestion_consultation.service;

import com.example.gestion_consultation.Entity.User;
import com.example.gestion_consultation.interfaces.Repository;
import jdk.jshell.spi.ExecutionControl;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Queue;

public class UserService extends BaseService implements Repository<User> {
    @Override
    public void end() {
        sessionFactory.close();
    }

    @Override
    public boolean create(User o) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(User o) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("update login");
    }

    @Override
    public boolean delete(User o) throws ExecutionControl.NotImplementedException{
        throw new ExecutionControl.NotImplementedException("delete login");
    }

    @Override
    public User findById(int id)throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("findbyid login");
    }

    @Override
    public List<User> findAll() throws ExecutionControl.NotImplementedException{
        throw new ExecutionControl.NotImplementedException("findAll login");
    }

    public User findByUsername (String username){
        User user;
        session= sessionFactory.openSession();
        Query<User> userQuery = session.createQuery("from user where userName = :username",User.class);
        userQuery.setParameter("username",username);
        user= userQuery.uniqueResult();
        session.close();
        return user;
    }
}
