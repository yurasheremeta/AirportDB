package ua.airlines.Entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.airlines.Entity.Enums.SitsClass;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "ticket")
public class Ticket extends BaseEntity{
	@Column(nullable = false)
	private String seat;
	
	@Column(name = "departure_date" , nullable = false)
	private String departureDate;
	
	@Column(name = "arrival_date" , nullable= false)
	private String arrivalDate;
	
	@Column(nullable = false , columnDefinition = "DECIMAL(7,2)")
	private BigDecimal price;
	
	@ManyToOne
	@JoinColumn(name = "flight_id" , nullable = false)
	private Flight flight;
	
	@ManyToOne
	@JoinColumn(name = "passenger_id" , nullable= false)
	private Passenger passenger;
	
	@Enumerated(EnumType.STRING)
	private SitsClass sitsClass;

}
