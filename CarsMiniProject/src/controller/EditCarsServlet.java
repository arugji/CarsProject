package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cars;


/**
 * Servlet implementation class EditCarsServlet
 */
@WebServlet("/editCarsServlet")
public class EditCarsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CarsHelper ch;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCarsServlet() {
        super();
        // TODO Auto-generated constructor stub
        ch = new CarsHelper();
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name = request.getParameter("name");
		String color = request.getParameter("color");
		String path = "/viewAllCarsServlet";
		int tempId = Integer.parseInt(request.getParameter("id"));
		
		Cars car = ch.findCarById(tempId);
		car.setName(name);
		car.setColor(color);
		ch.updateCar(car);
		getServletContext().getRequestDispatcher(path).forward(request, response);
		
	}

}
