package by.karpov.service;

import by.karpov.dao.DoctorDaoImpl;
import by.karpov.entity.Doctor;
import by.karpov.entity.Person;

import java.util.List;

public class DoctorServiceImpl implements PersonService<Doctor> {

    @Override
    public boolean save(Doctor doctor) {
        DoctorDaoImpl doctorDao = DoctorDaoImpl.newInstance();
        doctorDao.save(doctor);
        return true;
    }

    @Override
    public List<Doctor> read() {
        DoctorDaoImpl doctorDao = DoctorDaoImpl.newInstance();
        return doctorDao.getDoctors();
    }

    @Override
    public Doctor find(Doctor doctor) {
        DoctorDaoImpl doctorDao = DoctorDaoImpl.newInstance();
        return doctorDao.find(doctor);
    }
}
