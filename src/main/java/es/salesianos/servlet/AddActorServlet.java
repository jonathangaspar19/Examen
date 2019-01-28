package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Actor;
import es.salesianos.model.assembler.ExamAssembler;
import es.salesianos.service.ActorService;

/**
 * Servlet implementation class addOwnerServlet
 */
public class AddActorServlet extends HttpServlet {
	private ActorService service = new ActorService();
	private ExamAssembler assembler = new ExamAssembler();

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parameter = req.getParameter("beginDate");
		if (parameter != null) {
			int beginDate = Integer.parseInt(req.getParameter("beginDate"));
			int endDate = Integer.parseInt(req.getParameter("endDate"));
			List<Actor> listAllActores = service.filterAllActor(beginDate, endDate);
			req.setAttribute("listAllActors", listAllActores);
		} else {
			Actor actor = assembler.assembleActorFromRequest(req);

			service.addActor(actor);
			List<Actor> listAllActores = service.selectAllActor();
			req.setAttribute("listAllActors", listAllActores);
		}
		
		redirect(req,resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addActor.jsp");
		dispatcher.forward(req,resp);
	}
}
