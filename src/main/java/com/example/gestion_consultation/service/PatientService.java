package com.example.gestion_consultation.service;

import com.example.gestion_consultation.Entity.Patient;
import com.example.gestion_consultation.interfaces.Repository;
import org.hibernate.query.Query;

import java.util.List;

public class PatientService extends BaseService implements Repository<Patient> {

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
    public boolean create(Patient o) {
        try{
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Patient o) {
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
    public boolean delete(Patient o) {
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
    public Patient findById(int id) {
        return session.get(Patient.class, id);
    }

    @Override
    public List<Patient> findAll() {
        return session.createQuery("from patient ", Patient.class).list();
    }

    public List<Patient> findByName (String name){
        Query<Patient> patientQuery = session.createQuery("from patient as p where p.nom like :name",Patient.class);
        patientQuery.setParameter("name",name);
        return patientQuery.getResultList();
    }
}
