package by.karpov.service;

import by.karpov.entity.Patient;
import by.karpov.entity.Person;

import java.util.ArrayList;
import java.util.List;

public class PatientServiceImpl implements PersonService<Patient> {

    @Override
    public boolean save(Patient patient) {
        return false;
    }

    @Override
    public List<Patient> read() {
        List<Patient> patients = new ArrayList<>();
        return patients;
    }

    @Override
    public Patient find(Patient entity) {
        return null;
    }
}