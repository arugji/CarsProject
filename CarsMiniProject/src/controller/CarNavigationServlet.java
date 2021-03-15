package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cars;


/**
 * Servlet implementation class CarNavigationServlet
 */
@WebServlet("/carNavigationServlet")
public class CarNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       CarsHelper ch;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarNavigationServlet() {
        super();
        ch = new CarsHelper();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		CarsHelper carN = new CarsHelper();
		String act = request.getParameter("doThisToItem");
		String path = "/viewAllCarsServlet";
		
		if(act.equals("delete")) {
			try{
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			ch.deleteCar(tempId);
			
			}
			catch(NumberFormatException e) {
				System.out.println("Forgot to select an item");
			}
		}
		else if(act.equals("edit")) {
			try {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Cars itemToEdit = carN.findCarById(tempId);
			request.setAttribute("itemToEdit", itemToEdit);
			path = "/edit-cars.jsp";
			}
			catch(NumberFormatException e) {
				System.out.println("Forgot to select an item");
			}
			
		}
		else if(act.equals("add")) {
			path="/index.html";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
		
	}

}
