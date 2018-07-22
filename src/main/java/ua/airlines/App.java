package ua.airlines;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ua.airlines.Entity.Aircompany;
import ua.airlines.Entity.Country;
import ua.airlines.Entity.Destination;
import ua.airlines.Entity.Flight;
import ua.airlines.Entity.Passenger;
import ua.airlines.Entity.Plane;
import ua.airlines.Entity.Ticket;
import ua.airlines.Entity.Enums.PlaneType;
import ua.airlines.Entity.Enums.SitsClass;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("logos");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        
//        addCountryAndCity(em);
//       addCompanyAndPlane(em);
//        addFlight(em);
//      addPassenger(em);
        addTicket(em);
        em.getTransaction().commit();
        
        
        em.close();
        factory.close();
    }
    
    private static void addCountryAndCity(EntityManager em) {
    	Country country = new Country();
    	country.setName("Ukraine");
    	em.persist(country);
    	
    	Destination destination = new Destination();
    	destination.setCity("Lviv");
    	destination.setCountry(country);
    	em.persist(destination);
    	
    	destination = new Destination();
    	destination.setCity("Kyiv");
    	destination.setCountry(country);
    	em.persist(destination);
    }
    
    private static void addCompanyAndPlane(EntityManager em) {
    	Aircompany airCompany = new Aircompany();
    	airCompany.setCompanyName("WizzAir");
    	airCompany.setCompanyAddres("Doroshenka 23");
    	em.persist(airCompany);
    	
    	Plane plane = new Plane();
    	plane.setAircompany(airCompany);
    	plane.setPlaneType(PlaneType.BOEING_737_200);
    	em.persist(plane);
    	
    	plane = new Plane();
    	plane.setAircompany(airCompany);
    	plane.setPlaneType(PlaneType.AIRBUS_A220_180);
    	em.persist(plane);
    	
    }
    
    private static void addFlight(EntityManager em) {
    	Plane plane = em.createQuery("Select p from Plane p where p.id = :plane_id" , Plane.class)
    			.setParameter("plane_id", 2L)
    			.getSingleResult();
    	
    	Destination destination = 
    			em.createQuery("Select d from Destination d where d.id = :dId" , Destination.class)
    			.setParameter("dId" , 1L)
    			.getSingleResult();
    	
    	Flight flight = new Flight();
    	flight.setDestination(destination);
    	flight.setPlane(plane);
    	flight.setDepartureTime("2018-008-04 12:00");
    	flight.setArrivalTime("2018-08-04 19:15");
    	flight.setTravelTime("07:15");
    	em.persist(flight);
    }
    
    private static void addPassenger(EntityManager em) {
    	Passenger passenger = new Passenger();
    	passenger.setFirstName("Yura");
    	passenger.setLastName("Sheremeta");
    	passenger.setPassportNumber("AA00000");
    	passenger.setPassportGiven("2014-12-12");
    	em.persist(passenger);
    	
    	passenger = new Passenger();
    	passenger.setFirstName("Tom");
    	passenger.setLastName("Tomson");
    	passenger.setPassportNumber("AA00000");
    	passenger.setPassportGiven("2008-12-12");
    	em.persist(passenger);
    }
    
    private static void addTicket(EntityManager em) {
    	Flight flight = em.createQuery("Select f from Flight f where f.id = :fId" , Flight.class)
    			.setParameter("pId", 1L)
    			.getSingleResult();
    	Passenger passenger = em.createQuery("Select p from Passenger p where p.id =: pId", Passenger.class)
    			.setParameter("pId", 1L).getSingleResult();
    	
    	Ticket ticket = new Ticket();
    	
    	ticket.setFlight(flight);
    	ticket.setPassenger(passenger);
    	ticket.setPrice(new BigDecimal("400.00"));
    	ticket.setSitsClass(SitsClass.ECONOMY);
    	ticket.setSeat("A30");
    	ticket.setDepartureDate(flight.getDepartureTime());
    	ticket.setArrivalDate(flight.getArrivalTime());
    	em.persist(ticket);
    	
    	
    }
}
