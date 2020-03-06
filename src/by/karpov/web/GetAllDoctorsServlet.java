package by.karpov.web;

import by.karpov.entity.Doctor;
import by.karpov.service.DoctorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/getDoctors", name = "GetAllDoctorsServlet")
public class GetAllDoctorsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DoctorServiceImpl doctorService = new DoctorServiceImpl();
        List<Doctor> doctors = doctorService.read();
        StringBuilder result = new StringBuilder();
        for(Doctor doctor : doctors){
            result.append("<p>")
                    .append(doctor.getName() + " ")
                    .append(doctor.getSurname() + " | ")
                    .append("address: " + doctor.getAddress() + " | ")
                    .append("sex: " + doctor.getSex() + " | ")
                    .append("Specialty - " + doctor.getSpecialty()).append("</p>");
        }
        response.getWriter().write(result.toString());
    }
}
