package by.karpov.web;

import by.karpov.entity.Patient;
import by.karpov.service.AuthenticationPatientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static util.ServletUtil.createViewPath;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private static Map<String, Locale> LOCALES = new HashMap<>();

    static {
        LOCALES.put("ru", new Locale("ru", "RU"));
        LOCALES.put("en", new Locale("en", "EN"));
    }

    public static Locale getLocale(String str) {
        if (LOCALES.containsKey(str)) {
            return LOCALES.get(str);
        } else {
            return Locale.getDefault();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        if (new AuthenticationPatientService().authentication(name, surname)) {
            request.getSession().setAttribute("currentUser", new Patient.Builder().setName(name).setSurname(surname).build());
            response.sendRedirect("/visit");
        } else {
            response.sendRedirect("/login");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String str = request.getParameter("language");
        request.setAttribute("language", getLocale(str));

        getServletContext()
                .getRequestDispatcher(createViewPath("blocks/login"))
                .forward(request, response);
    }
}
