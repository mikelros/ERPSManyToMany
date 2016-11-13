package org.hibernate.ros.exam04.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.ros.hibernate.exam04.HibernateSession;
import org.ros.hibernate.exam04.dao.DoctorDAO;
import org.ros.hibernate.exam04.models.Doctor;
import org.ros.hibernate.exam04.models.Patient;

public class HibernateDoctorDAO implements DoctorDAO {

	public List<Doctor> selectAll() {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    List<Doctor> doctors = session.createCriteria(Doctor.class).list();
	    session.close();
	    return doctors;
	}

	public void insert(Doctor doctor) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	    session.merge(doctor);	         
	    session.getTransaction().commit();
	    session.close();
	}

}
