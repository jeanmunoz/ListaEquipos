package com.listaequipos.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.listaequipos.models.Roster;

/**
 * Servlet implementation class Teams
 */
@WebServlet("/teams")
public class Teams extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teams() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		HttpSession session = request.getSession();
		
		if(session.isNew()) {
			Roster roster = new Roster();
			session.setAttribute("roster", roster);
		}
		
		String id = request.getParameter("id") != null ? request.getParameter("id") : "-1";
		session.setAttribute("teamID", id);
		

		
		
		if(id.equals("-1")) {
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/newTeam.jsp");
			view.forward(request, response);
		} else {
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/teamInfo.jsp");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Roster roster = (Roster) session.getAttribute("roster");
		
		if(request.getParameter("submit") != null) {
			roster.addTeam(request.getParameter("teamName"));
		}
		
		session.setAttribute("roster", roster);
		response.sendRedirect("./home");
	}

}
