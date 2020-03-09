package by.karpov.web;

import by.karpov.entity.Patient;
import by.karpov.entity.Sex;
import by.karpov.service.PatientServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/setPatient", "/getPatient"}, name = "PatientServlet")
public class PatientServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PatientServiceImpl patientService = new PatientServiceImpl();
        boolean result = patientService.save(new Patient.Builder()
                .setName(request.getParameter("name"))
                .setSurname(request.getParameter("surname"))
                .setAddress(request.getParameter("address"))
                .setSex(Sex.valueOf(request.getParameter("sex"))).build());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        PatientServiceImpl patientService = new PatientServiceImpl();
        Patient patient = patientService.find(id);
        response.getWriter().write(patient.getName() + " " + patient.getSurname());
    }
}
