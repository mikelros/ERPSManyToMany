package org.hibernate.ros.exam04.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.ros.hibernate.exam04.HibernateSession;
import org.ros.hibernate.exam04.dao.PatientDAO;
import org.ros.hibernate.exam04.models.Patient;

public class HibernatePatientDAO implements PatientDAO {

	public List<Patient> selectAll() {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    List<Patient> patients = session.createCriteria(Patient.class).list();
	    session.close();
	    return patients;
	}

	public void insert(Patient patient) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	    session.merge(patient);	         
	    session.getTransaction().commit();
	    session.close();
	}

}
