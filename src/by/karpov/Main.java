package by.karpov;

import by.karpov.dao.PatientDaoImpl;
import by.karpov.service.AuthenticationPatientService;

public class Main {
    public static void main(String[] args) {


        /*PatientDaoImpl patientDao = PatientDaoImpl.getInstance();
        patientDao.read();*/
        /*DoctorDaoImpl doctorDao = DoctorDaoImpl.getInstance();
        doctorDao.read();*/
        PatientDaoImpl patientDao = PatientDaoImpl.getInstance();
        System.out.println(patientDao.authentication("Bob", "Marley"));
        System.out.println(new AuthenticationPatientService().authentication("Tom", "Hanks"));
    }
}
