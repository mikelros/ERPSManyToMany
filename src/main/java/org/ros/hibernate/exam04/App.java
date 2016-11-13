package org.ros.hibernate.exam04;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.ros.exam04.impl.HibernateDoctorDAO;
import org.hibernate.ros.exam04.impl.HibernatePatientDAO;
import org.ros.hibernate.exam04.dao.DoctorDAO;
import org.ros.hibernate.exam04.dao.PatientDAO;
import org.ros.hibernate.exam04.models.Doctor;
import org.ros.hibernate.exam04.models.Patient;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		DoctorDAO doctorDAO = new HibernateDoctorDAO();
		PatientDAO patientDAO = new HibernatePatientDAO();

		Doctor doctor =  new Doctor("First Doctor", "AEIOU");

		List<Doctor> doctors = new ArrayList<Doctor>();
		doctors.add(doctor);

		Patient patient1 = new Patient("First patient", "Hombre");
		Patient patient2 = new Patient("Second patient", "Mujer");
		Patient patient3 = new Patient("Third patient", "Hombre");
		
		List<Patient> patients = new ArrayList<Patient>();
		patients.add(patient1);
		patients.add(patient2);
		patients.add(patient3);

		doctor.setPatients(patients);

		patient1.setDoctors(doctors);
		patient2.setDoctors(doctors);

		doctorDAO.insert(doctor);

		List<Doctor> doctorsFromDB = doctorDAO.selectAll();

		for (Doctor doctore : doctorsFromDB) {
			String result = "";
			result = "Id: " + doctore.getId() + "Name: " + doctore.getName() + ", Area: " + doctore.getArea()	+ ", Patients: ";

			System.out.println(result);

			List<Patient> patientsFromDB = doctore.getPatients();

			for (int i = 0; i < patientsFromDB.size(); i++) {
				System.out.println("   * " + patients.get(i).toString());
			}
		}
	}
}
