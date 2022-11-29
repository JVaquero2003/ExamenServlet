package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Champions;
import repository.ChampionRepository;
@WebServlet("/insertChampion")
public class InsertChampionServlet extends BaseServlet{

	ChampionRepository repository = new ChampionRepository();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Champions champion = getChampionInsert(req);
		repository.insertChampion(champion);
		redirect(req, resp, "/index.jsp");
	}
}
