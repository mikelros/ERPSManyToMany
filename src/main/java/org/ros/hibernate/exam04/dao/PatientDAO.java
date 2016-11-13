package org.ros.hibernate.exam04.dao;

import java.util.List;

import org.ros.hibernate.exam04.models.Patient;

public interface PatientDAO {
	public List<Patient> selectAll();

	public void insert(Patient patient);
}
