package by.karpov.web;

import by.karpov.entity.Doctor;
import by.karpov.entity.Patient;
import by.karpov.entity.Visit;
import by.karpov.service.VisitServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(urlPatterns = "/visit/therapist", name = "VisitTherapistServlet")
public class VisitTherapistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VisitServiceImpl visitService = new VisitServiceImpl();
        boolean result = visitService.save(new Doctor.Builder().setId(2L).build(),
                new Patient.Builder().setId(2L).build(),
                new Visit.Builder().setDate(LocalDate.parse(request.getParameter("date"))).build());
        if (result) {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            response.sendRedirect("/WEB-INF/jsp/therapist.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/jsp/therapist.jsp").forward(request, response);
    }
}
