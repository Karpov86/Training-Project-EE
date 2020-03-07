package by.karpov.service;

import by.karpov.dao.PatientDaoImpl;
import by.karpov.entity.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientServiceImpl implements PersonService<Patient> {

    @Override
    public boolean save(Patient patient) {
        PatientDaoImpl patientDao = PatientDaoImpl.getInstance();
        return patientDao.save(patient);
    }

    @Override
    public List<Patient> read() {
        List<Patient> patients = new ArrayList<>();
        return patients;
    }

    @Override
    public Patient find(Patient patient) {
        PatientDaoImpl patientDao = PatientDaoImpl.getInstance();
        return patientDao.find(patient);
    }
}