package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Optional;



import model.Champions;
import model.Champion_abilities;
import repository.Champion_abilitiesRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/listChampion_abilities")
public class ListChampion_abilitiesServlet extends BaseServlet{

	Champion_abilitiesRepository repository = new Champion_abilitiesRepository();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Champions champion = getChampionInsert(req);
		List<Champion_abilities> habilidades = repository.listarHabilidadesCampeon(champion);
		req.setAttribute("lista", habilidades);
		req.setAttribute("campeon", champion);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listChampion_abilities.jsp");
		dispatcher.forward(req, resp);
	}

}
