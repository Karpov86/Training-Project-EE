package by.karpov.dao;

import by.karpov.entity.Doctor;
import by.karpov.entity.Sex;
import by.karpov.entity.Specialty;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDaoImpl implements PersonDao<Doctor> {

    private static DoctorDaoImpl INSTANCE;

    private DoctorDaoImpl() {
    }

    public static DoctorDaoImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (DoctorDaoImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DoctorDaoImpl();
                }
            }
        }
        return INSTANCE;
    }

    public boolean save(Doctor doctor) {

        try (Connection connection = ConnectionManager.newConnection()) {
            String sql = "INSERT INTO doctors (name, surname, address, sex, specialty, work_experience) VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, doctor.getName());
            statement.setString(2, doctor.getSurname());
            statement.setString(3, doctor.getAddress());
            statement.setString(4, String.valueOf(doctor.getSex()));
            statement.setString(5, String.valueOf(doctor.getSpecialty()));
            statement.setInt(6, doctor.getWorkExperience());
            statement.executeUpdate();

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean updateAddress(Doctor doctor) {

        try (Connection connection = ConnectionManager.newConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE doctors SET address = ? WHERE id = ?;");
            statement.setString(1, new Doctor().getAddress());
            statement.setLong(2, doctor.getId());
            statement.executeUpdate();

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean delete(Doctor doctor) {

        try (Connection connection = ConnectionManager.newConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM doctors WHERE id = ?;");
            statement.setLong(1, doctor.getId());
            statement.executeUpdate();

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void read() {

        try (Connection connection = ConnectionManager.newConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM doctors;");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString("name") + " " + resultSet.getString("surname")
                        + "\naddress: " + resultSet.getString("address") + "\nsex: " + resultSet.getString("sex") + ", specialty: " +
                        resultSet.getString("specialty") + "\nwork experience " + resultSet.getInt("work_experience") + " years");
                System.out.println("===========================================================");
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Doctor> getDoctors() {
        ArrayList<Doctor> doctors = new ArrayList<>();
        try (Connection connection = ConnectionManager.newConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM doctors;");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                doctors.add(new Doctor.Builder()
                        .setName(resultSet.getString("name"))
                        .setSurname(resultSet.getString("surname"))
                        .setAddress(resultSet.getString("address"))
                        .setSex(Sex.valueOf(resultSet.getString("sex")))
                        .setWorkExperience(resultSet.getInt("work_experience"))
                        .setSpecialty(Specialty.valueOf(resultSet.getString("specialty")))
                        .build());
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctors;
    }

    @Override
    public Doctor find(Doctor doctor) {
        Doctor reqDoctor = null;
        try (Connection connection = ConnectionManager.newConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM doctors WHERE id = ?;");
            statement.setLong(1, doctor.getId());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                reqDoctor = new Doctor.Builder()
                        .setName(resultSet.getString("name"))
                        .setSurname(resultSet.getString("surname"))
                        .setAddress(resultSet.getString("address"))
                        .setSex(Sex.valueOf(resultSet.getString("sex")))
                        .setWorkExperience(resultSet.getInt("work_experience"))
                        .setSpecialty(Specialty.valueOf(resultSet.getString("specialty")))
                        .build();
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return reqDoctor;
    }
}
