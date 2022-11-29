package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Champion_abilities;
import repository.Champion_abilitiesRepository;

@WebServlet("/comparadorRangos")
public class BuscarChampion_abilitiesServlet extends BaseServlet{

	Champion_abilitiesRepository repository = new Champion_abilitiesRepository();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        int rango_1 = Integer.parseInt(req.getParameter("rango_1"));
        int rango_2 = Integer.parseInt(req.getParameter("rango_2"));
        List<Champion_abilities> habilidades = repository.listAll(rango_1, rango_2);
        req.setAttribute("lista", habilidades);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listChampion_abilities.jsp");
        dispatcher.forward(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int rango_1 = 0;
        int rango_2 = 50000;
        List<Champion_abilities> habilidades = repository.listAll(rango_1, rango_2);
        req.setAttribute("lista", habilidades);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listChampion_abilities.jsp");
        dispatcher.forward(req, resp);
    }
}
