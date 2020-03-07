package by.karpov.dao;

import by.karpov.entity.Doctor;
import by.karpov.entity.Patient;
import by.karpov.entity.Visit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class VisitDaoImpl implements VisitDao<Doctor, Patient, Visit> {

    private static VisitDaoImpl INSTANCE;

    private VisitDaoImpl() {
    }

    public static VisitDaoImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (VisitDaoImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new VisitDaoImpl();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public boolean save(Doctor doctor, Patient patient, Visit visit) {

        try (Connection connection = ConnectionManager.newConnection()) {
            String sql = "INSERT INTO visits (date, doctor_id, patient_id) VALUES (?, ?, ?);";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, visit.getDate());
            statement.setLong(2, doctor.getId());
            statement.setLong(3, patient.getId());
            statement.executeUpdate();

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public void read() {

    }

    @Override
    public boolean update(Visit visit) {
        return false;
    }

    @Override
    public boolean delete(Visit visit) {
        return false;
    }
}
