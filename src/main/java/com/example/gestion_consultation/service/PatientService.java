package com.example.gestion_consultation.service;

import com.example.gestion_consultation.Entity.Patient;
import com.example.gestion_consultation.interfaces.Repository;
import org.hibernate.query.Query;

import java.util.List;

public class PatientService extends BaseService implements Repository<Patient> {



    @Override
    public void end() {

        sessionFactory.close();
    }

    @Override
    public boolean create(Patient o) {
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
            session.close();
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Patient o) {
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(o);
            session.getTransaction().commit();
            session.close();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean delete(Patient o) {
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(o);
            session.getTransaction().commit();
            session.close();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Patient findById(int id) {
        Patient patient;
        session = sessionFactory.openSession();
        patient = session.get(Patient.class, id);
        session.close();
        return  patient;
    }

    @Override
    public List<Patient> findAll() {
        List<Patient> patients = null;
        session = sessionFactory.openSession();
        patients= session.createQuery("from patient ", Patient.class).list();
        session.close();
        return patients;
    }

    public List<Patient> findByName (String name){
        List<Patient>patients=null;
        session = sessionFactory.openSession();
        Query<Patient> patientQuery = session.createQuery("from patient as p where p.nom like :name",Patient.class);
        patientQuery.setParameter("name",name);
        patients= patientQuery.getResultList();
        session.close();
        return patients;
    }
}
