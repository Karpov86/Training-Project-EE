package by.karpov.service;

import by.karpov.dao.DoctorDaoImpl;
import by.karpov.entity.Doctor;

import java.util.List;

public class DoctorServiceImpl implements PersonService<Doctor> {

    @Override
    public boolean save(Doctor doctor) {
        DoctorDaoImpl doctorDao = DoctorDaoImpl.getInstance();
        return doctorDao.save(doctor);
    }

    @Override
    public List<Doctor> read() {
        DoctorDaoImpl doctorDao = DoctorDaoImpl.getInstance();
        return doctorDao.getDoctors();
    }

    @Override
    public Doctor find(Doctor doctor) {
        DoctorDaoImpl doctorDao = DoctorDaoImpl.getInstance();
        return doctorDao.find(doctor);
    }
}
