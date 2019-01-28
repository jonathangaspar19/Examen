package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Director;
import es.salesianos.model.assembler.ExamAssembler;
import es.salesianos.service.DirectorService;

/**
 * Servlet implementation class addOwnerServlet
 */
public class AddDirectorServlet extends HttpServlet {
	private DirectorService service = new DirectorService();
	private ExamAssembler assembler = new ExamAssembler();

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Director director = assembler.assembleDirectorFromRequest(req);
		service.addDirector(director);
		redirect(req,resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addDirector.jsp");
		dispatcher.forward(req,resp);
	}
}
