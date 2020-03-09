package by.karpov.web;

import by.karpov.entity.Doctor;
import by.karpov.entity.Specialty;
import by.karpov.service.VisitServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(urlPatterns = "/visit", name = "VisitServlet")

public class VisitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/jsp/visit.jsp").forward(request, response);
        List<LocalDate> freeDates = new VisitServiceImpl().getFreeDates(new Doctor.Builder().setSpecialty(Specialty.valueOf(request.getParameter("specialty"))).build());
        StringBuilder stringBuilder = new StringBuilder();
        for (LocalDate date : freeDates) {
            stringBuilder.append(date + "    ");
        }
        response.getWriter().write(String.valueOf(stringBuilder));
    }
}
