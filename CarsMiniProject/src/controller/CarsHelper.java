package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Cars;



public class CarsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("cars");
	
	
	//insertCar method will add a new car to the list
	public void insertCar(Cars c) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}
	
	//updateCar works as the edit method to edit a Car information
	public void updateCar(Cars toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	//deleteCar will delete a car by selecting the id for the car
	public void deleteCar(int id) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Cars car = em.find(Cars.class, id);
		em.remove(car);
		em.getTransaction().commit();
		em.close();
	}
	
	//returns the list of the cars on the list
	public List<Cars> findAllCars(){
		EntityManager em = emfactory.createEntityManager();
		List<Cars> cars = em.createQuery("SELECT c FROM Cars c").getResultList();
		em.close();
		return cars;
	}
	
	//search for a car by the id 
	public Cars findCarById(int id) {
		EntityManager em= emfactory.createEntityManager();
		em.getTransaction().begin();
		Cars car = em.find(Cars.class, id);
		em.close();
		return car;
	}
	
	

}
