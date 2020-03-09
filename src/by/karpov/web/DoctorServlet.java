package by.karpov.web;

import by.karpov.entity.Doctor;
import by.karpov.entity.Sex;
import by.karpov.entity.Specialty;
import by.karpov.service.DoctorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/getDoctor", "/setDoctor"}, name = "DoctorServlet")
public class DoctorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DoctorServiceImpl doctorService = new DoctorServiceImpl();
        doctorService.save(new Doctor.Builder()
                .setName(request.getParameter("name"))
                .setSurname(request.getParameter("surname"))
                .setAddress(request.getParameter("address"))
                .setSex(Sex.valueOf(request.getParameter("sex")))
                .setWorkExperience(Integer.parseInt(request.getParameter("work experience")))
                .setSpecialty(Specialty.valueOf(request.getParameter("specialty"))).build());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        DoctorServiceImpl doctorService = new DoctorServiceImpl();
        Doctor doctor = doctorService.find(id);
        response.getWriter().write(doctor.getName() + " " + doctor.getSurname());
    }
}
