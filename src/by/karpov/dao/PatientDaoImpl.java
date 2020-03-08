package by.karpov.dao;

import by.karpov.entity.Patient;
import by.karpov.entity.Sex;

import java.sql.*;

public class PatientDaoImpl implements PersonDao<Patient> {
    private static PatientDaoImpl INSTANCE;

    private PatientDaoImpl() {
    }

    public static PatientDaoImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (PatientDaoImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new PatientDaoImpl();
                }
            }
        }
        return INSTANCE;
    }

    public boolean save(Patient patient) {

        try (Connection connection = ConnectionManager.newConnection()) {
            String sql = "INSERT INTO patients (name, surname, address, sex) VALUES (?, ?, ?, ?);";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, patient.getName());
            statement.setString(2, patient.getSurname());
            statement.setString(3, patient.getAddress());
            statement.setString(4, String.valueOf(patient.getSex()));
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

        try (Connection connection = ConnectionPool.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM patients;");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString("name") + " " + resultSet.getString("surname"));
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean updateAddress(Patient patient) {
        return false;
    }

    @Override
    public boolean delete(Patient patient) {
        return false;
    }

    @Override
    public Patient find(Patient patient) {
        Patient reqPatient = null;
        try (Connection connection = ConnectionManager.newConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM patients WHERE id = ?;");
            statement.setLong(1, patient.getId());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                reqPatient = new Patient.Builder()
                        .setName(resultSet.getString("name"))
                        .setSurname(resultSet.getString("surname"))
                        .setAddress(resultSet.getString("address"))
                        .setSex(Sex.valueOf(resultSet.getString("sex")))
                        .build();
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reqPatient;
    }
}
