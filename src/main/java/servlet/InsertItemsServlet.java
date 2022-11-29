package servlet;

import java.io.IOException;
import java.util.Optional;



import model.Items;
import repository.ItemsRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/insertItems")
public class InsertItemsServlet extends BaseServlet{

	ItemsRepository repository = new ItemsRepository();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Items item = getItemFromRequest(req);
	
		repository.insert(item);
		redirect(req, resp, "/index.jsp");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

}
