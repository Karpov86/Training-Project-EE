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

@WebServlet(urlPatterns = "/patient/save", name = "SavePatientServlet")
public class SavePatientServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PatientServiceImpl patientService = new PatientServiceImpl();
        boolean result = patientService.save(new Patient.Builder()
                .setName(request.getParameter("name"))
                .setSurname(request.getParameter("surname"))
                .setAddress(request.getParameter("address"))
                .setSex(Sex.valueOf(request.getParameter("sex"))).build());
        if (result) {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            response.sendRedirect("/WEB-INF/jsp/save-patient.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/jsp/save-patient.jsp").forward(request, response);
    }
}
