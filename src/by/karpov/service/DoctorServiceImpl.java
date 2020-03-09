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

    public List<Doctor> findAll() {
        DoctorDaoImpl doctorDao = DoctorDaoImpl.getInstance();
        return doctorDao.findAll();
    }

    @Override
    public Doctor find(Long id) {
        DoctorDaoImpl doctorDao = DoctorDaoImpl.getInstance();
        return doctorDao.find(id);
    }
}
