package by.karpov.service;

import by.karpov.dao.PatientDaoImpl;
import by.karpov.entity.Patient;

import java.util.List;

public class PatientServiceImpl implements PersonService<Patient> {

    @Override
    public boolean save(Patient patient) {
        PatientDaoImpl patientDao = PatientDaoImpl.getInstance();
        return patientDao.save(patient);
    }

    @Override
    public Patient find(Long id) {
        PatientDaoImpl patientDao = PatientDaoImpl.getInstance();
        return patientDao.find(id);
    }

    @Override
    public List<Patient> findAll() {
        return null;
    }
}