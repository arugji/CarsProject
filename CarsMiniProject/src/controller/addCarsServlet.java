package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cars;

/**
 * Servlet implementation class addCarsServlet
 * @author Tyler Maschoff
 * CIS175
 */
@WebServlet("/addCarsServlet")
public class addCarsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//private carshelper variable. to implement methods for adding car
	private CarsHelper ch;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addCarsServlet() {
        super();
        // TODO Auto-generated constructor stub
        ch = new CarsHelper();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String color = request.getParameter("color");
		Cars carN= new Cars(name,color);
		CarsHelper dao= new CarsHelper();
		dao.insertCar(carN);
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
