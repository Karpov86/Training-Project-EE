package by.karpov.service;

import by.karpov.dao.InsuranceDaoImpl;
import by.karpov.entity.Insurance;
import by.karpov.entity.Patient;

public class InsuranceServiceImpl implements InsuranceService<Insurance, Patient> {

    @Override
    public boolean save(Insurance insurance, Patient patient) {
        InsuranceDaoImpl insuranceDao = InsuranceDaoImpl.getInstance();
        insuranceDao.save(insurance, patient);
        return true;
    }

    @Override
    public boolean read() {
        InsuranceDaoImpl insuranceDao = InsuranceDaoImpl.getInstance();
        insuranceDao.read();
        return true;
    }
}
