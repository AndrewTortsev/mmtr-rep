package tutorial;


import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TESTService dao = new TESTService();
        if (request.getParameter("update") != null) {
            TEST row = new TEST();
            row.setId(Integer.parseInt(request.getParameter("id")));
            row.setF1(request.getParameter("f1").charAt(0));
            row.setF2(request.getParameter("f2").charAt(0));
            row.setF3(request.getParameter("f3").charAt(0));
            try {
                dao.update(row);
            }catch (Exception e){

            }
            request.setAttribute("list", dao.getAll());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("mainPage.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TESTService dao = new TESTService();
        if (request.getParameterMap().size()==0) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request, response);
            return;
        }
        if (request.getParameter("add") != null) {
            TEST row = new TEST();
            row.setId(Integer.parseInt(request.getParameter("id")));
            row.setF1(request.getParameter("f1").charAt(0));
            row.setF2(request.getParameter("f2").charAt(0));
            row.setF3(request.getParameter("f3").charAt(0));
            try {
                dao.create(row);
            }catch (Exception e){

            }
            request.setAttribute("list", dao.getAll());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("mainPage.jsp");
            requestDispatcher.forward(request, response);
        }
        if (request.getParameter("getAll") != null) {
            request.setAttribute("list", dao.getAll());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("mainPage.jsp");
            requestDispatcher.forward(request, response);
        }

        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("update")) {
            request.setAttribute("row", dao.getByID(Integer.parseInt(request.getParameter("idRow"))));
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("mainPage.jsp");
            requestDispatcher.forward(request, response);
        }
        if (action.equalsIgnoreCase("delete")) {
            try {
                dao.delete(Integer.parseInt(request.getParameter("idRow")));
            } catch (Exception e) {
                e.printStackTrace();
            }
            request.setAttribute("list", dao.getAll());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("mainPage.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
