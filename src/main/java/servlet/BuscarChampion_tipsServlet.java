package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Champion_abilities;
import model.Champion_tips;
import model.Champions;
import repository.Champion_tipsRepository;
@WebServlet("/buscarChampion_tips")
public class BuscarChampion_tipsServlet extends BaseServlet {

Champion_tipsRepository repository = new Champion_tipsRepository();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int rango_1 = Integer.parseInt(req.getParameter("rango_1"));
        int rango_2 = Integer.parseInt(req.getParameter("rango_2"));
		Champions champion = getChampionInsert(req);
		List<Champion_tips> tips = repository.listarTipsCampeon(champion);
		req.setAttribute("lista", tips);
		req.setAttribute("campeon", champion);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listChampion_abilities.jsp");
		dispatcher.forward(req, resp);
	}
}
