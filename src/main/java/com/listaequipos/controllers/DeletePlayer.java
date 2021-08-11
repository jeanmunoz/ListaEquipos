package com.listaequipos.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.listaequipos.models.Roster;

/**
 * Servlet implementation class DeletePlayer
 */
@WebServlet("/deletePlayer")
public class DeletePlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePlayer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Roster roster = (Roster) session.getAttribute("roster");
		
		String teamID = request.getParameter("teamID") != null ? request.getParameter("teamID") : "-1";
		String playerID = request.getParameter("playerID") != null ? request.getParameter("playerID") : "-1";
		
		if(!teamID.equals("-1") && !playerID.equals("-1")) {
			roster.getTeam(Integer.parseInt(teamID)).removePlayer(Integer.parseInt(playerID));
		}
		
		session.setAttribute("roster", roster);
		response.sendRedirect("./teams?id="+teamID);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
