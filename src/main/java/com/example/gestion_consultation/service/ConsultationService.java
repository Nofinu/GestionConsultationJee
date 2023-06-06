package com.example.gestion_consultation.service;

import com.example.gestion_consultation.Entity.Consultation;
import com.example.gestion_consultation.Entity.FicheSoins;
import com.example.gestion_consultation.Entity.Prescription;
import com.example.gestion_consultation.interfaces.Repository;

import java.util.List;

public class ConsultationService extends BaseService implements Repository<Consultation> {

    @Override
    public void end() {
        sessionFactory.close();
    }

    @Override
    public boolean create(Consultation o) {
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

    public boolean createFicheSoins(FicheSoins o) {
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

    public boolean createPrescription(Prescription o) {
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
    public boolean update(Consultation o) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(o);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(Consultation o) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(o);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Consultation findById(int id) {
        Consultation consultation;
        session = sessionFactory.openSession();
        consultation = session.get(Consultation.class, id);
        session.close();
        return consultation;
    }

    @Override
    public List<Consultation> findAll() {
        List<Consultation> consultations = null;
        session = sessionFactory.openSession();
        consultations =  session.createQuery("from consultation ", Consultation.class).list();
        session.close();
        return consultations;
    }
}
