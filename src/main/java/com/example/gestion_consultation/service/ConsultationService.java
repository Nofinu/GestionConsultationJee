package com.example.gestion_consultation.service;

import com.example.gestion_consultation.Entity.Consultation;
import com.example.gestion_consultation.Entity.FicheSoins;
import com.example.gestion_consultation.Entity.Prescription;
import com.example.gestion_consultation.interfaces.Repository;

import java.util.List;

public class ConsultationService extends BaseService implements Repository<Consultation> {
    @Override
    public void start() {
        session = sessionFactory.openSession();
    }

    @Override
    public void end() {
        session.close();
        sessionFactory.close();
    }

    @Override
    public boolean create(Consultation o) {
        try{
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean createFicheSoins(FicheSoins o) {
        try{
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean createPrescription(Prescription o) {
        try{
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean update(Consultation o) {
        try{
            session.beginTransaction();
            session.update(o);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean delete(Consultation o) {
        try{
            session.beginTransaction();
            session.delete(o);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Consultation findById(int id) {
        return session.get(Consultation.class, id);
    }

    @Override
    public List<Consultation> findAll() {
        return session.createQuery("from consultation ", Consultation.class).list();
    }
}
