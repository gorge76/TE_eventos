package com.emergentes.controlador;

import com.emergentes.dao.SeminarioDAO;
import com.emergentes.dao.SeminarioDAOImplementacion;
import com.emergentes.modelo.Seminario;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Index", urlPatterns = {"/Index"})
public class Index extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            SeminarioDAO dao = new SeminarioDAOImplementacion();
            int id;
            Seminario sem = new Seminario();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    request.setAttribute("seminario", sem);
                    request.getRequestDispatcher("formseminario.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    sem = dao.getById(id);
                    request.setAttribute("seminario", sem);
                    request.getRequestDispatcher("formseminario.jsp").forward(request, response);
                    break;
                default:
                    List<Seminario> lista = dao.getAll();
                    request.setAttribute("seminarios", lista);
                    request.getRequestDispatcher("listado.jsp").forward(request, response);
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        SeminarioDAO dao = new SeminarioDAOImplementacion();
        int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String expositor = request.getParameter("expositor");
        String fecha = request.getParameter("fecha");
        String hora = request.getParameter("hora");
        int cupo = Integer.parseInt(request.getParameter("cupo"));

        Seminario sem = new Seminario();
        sem.setId(id);
        sem.setTitulo(titulo);
        sem.setExpositor(expositor);
        sem.setFecha(fecha);
        sem.setHora(hora);
        sem.setCupo(cupo);
        if (id == 0) {
            try {
                /*Registro nuevo*/
                dao.insert(sem);
                response.sendRedirect("Index");
            } catch (Exception ex) {
                System.out.println("Error " + ex.getMessage());
            }
        } else {
            /*Edición*/
            try {
                dao.update(sem);
                response.sendRedirect("Index");
            } catch (Exception ex) {
                System.out.println("Error " + ex.getMessage());
            }
        }
    }

}
