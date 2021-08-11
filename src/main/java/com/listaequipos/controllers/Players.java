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
 * Servlet implementation class Players
 */
@WebServlet("/players")
public class Players extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Players() {
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
		
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/newPlayer.jsp");
			view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String teamID =  (String) session.getAttribute("teamID");
		int _teamID = Integer.valueOf(teamID);
		Roster roster = (Roster) session.getAttribute("roster");
		
		if(request.getParameter("submit") != null) {
			roster.getTeam(_teamID).addPlayer(request.getParameter("firstName"), request.getParameter("lastName"),  Integer.parseInt(request.getParameter("age")));
		}
		
		session.setAttribute("roster", roster);
		response.sendRedirect("./teams?id="+session.getAttribute("teamID"));
	}

}
