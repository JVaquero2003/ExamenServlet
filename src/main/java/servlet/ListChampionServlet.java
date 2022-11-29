package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Optional;



import model.Champions;
import repository.ChampionRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/listChampions")
public class ListChampionServlet extends BaseServlet{

	ChampionRepository repository = new ChampionRepository();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Champions> champions = repository.listAll();
		req.setAttribute("lista", champions);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listChampions.jsp");
		dispatcher.forward(req, resp);
	}

}
