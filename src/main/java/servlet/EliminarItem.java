package servlet;

import java.io.IOException;
import java.util.Optional;



import model.Items;
import repository.ItemsRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/eliminarItem")
public class EliminarItem extends BaseServlet{

	ItemsRepository repository = new ItemsRepository();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
	
		repository.delete(id);
		redirect(req, resp, "/index.jsp");
	}
	
	

}
