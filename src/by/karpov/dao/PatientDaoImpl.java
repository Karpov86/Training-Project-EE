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
    public boolean update(Patient patient, Patient newData) {

        try (Connection connection = ConnectionManager.newConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE patients SET name = ?, surname = ?, address = ?, sex = ? WHERE id = ?;");
            statement.setString(1, newData.getName());
            statement.setString(2, newData.getSurname());
            statement.setString(3, newData.getAddress());
            statement.setString(4, String.valueOf(newData.getSex()));
            statement.setLong(5, patient.getId());
            statement.executeUpdate();

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Long id) {

        try (Connection connection = ConnectionManager.newConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM patients WHERE id = ?;");
            statement.setLong(1, id);
            statement.executeUpdate();

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Patient find(Long id) {
        Patient reqPatient = null;
        try (Connection connection = ConnectionManager.newConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM patients WHERE id = ?;");
            statement.setLong(1, id);
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

    public boolean authentication(String name, String surname) {
        boolean result = false;
        try (Connection connection = ConnectionManager.newConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM patients WHERE name = ? AND surname = ?;");
            statement.setString(1, name);
            statement.setString(2, surname);
            ResultSet resultSet = statement.executeQuery();

            result = resultSet.next();

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
