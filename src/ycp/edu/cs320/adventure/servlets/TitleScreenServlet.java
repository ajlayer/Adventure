package ycp.edu.cs320.adventure.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TitleScreenServlet extends HttpServlet{
	    private static final long serialVersionUID = 1L;
	    
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {
	        
	        System.out.println("Title Servlet: doGet");
	        
	        req.getRequestDispatcher("/_view/titleScreen.jsp").forward(req, resp);
	    }
	    
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {
	        
	        System.out.println("Title Servlet: doPost");
        	
	        String button = req.getParameter("button");
	        HttpSession ses = req.getSession(true);
	        
	        // gets account_id of the account that was signed in from the index servlet 
	        Object account_id = req.getSession(false).getAttribute("id");
	        
	        System.out.println("ID: " + String.valueOf(account_id));
	        
	        if (button.equals("New Game")) {
	        	ses = req.getSession(true);
	        	ses.setAttribute("id",(int)account_id);
	          	resp.sendRedirect(req.getContextPath() + "/_view/game.jsp");
	            return; 
	        } 
	        
	        else if (button.equals("Edit Game")) {
	        	ses = req.getSession(true);
	        	ses.setAttribute("id",(int)account_id);
	          	resp.sendRedirect(req.getContextPath() + "/_view/game.jsp");
	            return; 
	        } 
	        
	        else if (button.equals("Load Game")){
	        	ses = req.getSession(true);
	        	ses.setAttribute("id",(int)account_id);
	          	resp.sendRedirect(req.getContextPath() + "/_view/loadGame.jsp");
	          	return; 
	        }
	    }
}
