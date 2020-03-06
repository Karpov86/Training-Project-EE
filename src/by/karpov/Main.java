package by.karpov;

import by.karpov.dao.DoctorDaoImpl;
import by.karpov.entity.Doctor;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        DoctorDaoImpl doctorDao = DoctorDaoImpl.newInstance();
        List<Doctor> doctors = doctorDao.getDoctors();
        for (Doctor d : doctors) {
            System.out.println(d.getName() + " " + d.getSurname() + "address: " + d.getAddress() + ", sex: " + d.getSex() + ", specialty: " + d.getSpecialty());
        }
        doctorDao.read();
    }
}
