package by.karpov.service;

import by.karpov.dao.PatientDaoImpl;

public class AuthenticationPatientService {

    public boolean authentication(String name, String surname) {

        return PatientDaoImpl.getInstance().authentication(name, surname);
    }
}
