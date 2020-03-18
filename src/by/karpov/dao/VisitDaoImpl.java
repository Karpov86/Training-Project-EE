package by.karpov.dao;

import by.karpov.entity.Doctor;
import by.karpov.entity.Patient;
import by.karpov.entity.Visit;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VisitDaoImpl implements VisitDao<Doctor, Patient, Visit> {

    private static final String GET_ALL_QUERY = "SELECT v.date, d.name, d.surname, d.specialty, p.name, p.surname " +
            "FROM visits v, doctors d, patients p " +
            "WHERE d.id=v.doctor_id " +
            "AND p.id=v.patient_id;";
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
            statement.setDate(1, Date.valueOf(visit.getDate()));
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

    /*@Override
    public void read() {

        try (Connection connection = ConnectionManager.newConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET_ALL_QUERY);
            ResultSet resultSet = statement.executeQuery();


            System.out.println("_____________________________________________________________");

            while (resultSet.next()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Date: " + resultSet.getDate("v.date") + " | Doctor " + resultSet.getString("d.name") + " " +
                        resultSet.getString("d.surname") + " | Patient " + resultSet.getString("p.name") + " " + resultSet.getString("p.surname"));
                System.out.println(stringBuilder);
                System.out.println("_____________________________________________________________");

            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
*/
    @Override
    public boolean update(Visit visit) {
        return false;
    }

    @Override
    public boolean delete(Visit visit) {
        return false;
    }

    public List<LocalDate> getReservedDate(Doctor doctor) {

        List<LocalDate> result = new ArrayList<>();

        try (Connection connection = ConnectionManager.newConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT v.date FROM visits v, doctors d " +
                    "WHERE d.id=v.doctor_id " +
                    "AND d.specialty=?;");
            statement.setString(1, String.valueOf(doctor.getSpecialty()));
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                result.add(LocalDate.parse(String.valueOf(resultSet.getDate("date"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
