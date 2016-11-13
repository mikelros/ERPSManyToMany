package org.ros.hibernate.exam04.dao;

import java.util.List;

import org.ros.hibernate.exam04.models.Doctor;

public interface DoctorDAO {
	public List<Doctor> selectAll();

	public void insert(Doctor doctor);
}
