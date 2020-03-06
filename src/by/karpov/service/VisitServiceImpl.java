package by.karpov.service;

import by.karpov.dao.VisitDao;
import by.karpov.dao.VisitDaoImpl;
import by.karpov.entity.Doctor;
import by.karpov.entity.Patient;
import by.karpov.entity.Visit;

public class VisitServiceImpl implements VisitService<Doctor, Patient, Visit> {

    @Override
    public boolean save(Doctor doctor, Patient patient, Visit visit) {
        VisitDaoImpl visitDao = VisitDaoImpl.newInstance();
        visitDao.save(doctor, patient, visit);
        return true;
    }

    @Override
    public boolean read() {
        VisitDaoImpl visitDao = VisitDaoImpl.newInstance();
        visitDao.read();
        return true;
    }
}
