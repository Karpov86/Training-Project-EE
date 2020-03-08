package by.karpov.service;

import by.karpov.dao.VisitDaoImpl;
import by.karpov.entity.Doctor;
import by.karpov.entity.Patient;
import by.karpov.entity.Visit;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VisitServiceImpl implements VisitService<Doctor, Patient, Visit> {

    @Override
    public boolean save(Doctor doctor, Patient patient, Visit visit) {
        VisitDaoImpl visitDao = VisitDaoImpl.getInstance();
        visitDao.save(doctor, patient, visit);
        return true;
    }

    private static List<LocalDate> getNextMonth() {
        List<LocalDate> nextMonth = new ArrayList<>();
        LocalDate actualDate = LocalDate.now();
        for (int i = 0; i < 31; i++) {
            nextMonth.add(actualDate.plusDays(i));
        }
        return nextMonth;
    }

    @Override
    public List<LocalDate> getFreeDates(Doctor doctor) {
        List<LocalDate> freeDates = new ArrayList<>(getNextMonth());
        List<LocalDate> reservedDates = VisitDaoImpl.getInstance().getReservedDate(doctor);
        freeDates.removeIf(n -> reservedDates.contains(n));
        return freeDates;
    }
}
