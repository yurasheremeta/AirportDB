package ua.airlines.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "destination")
public class Destination extends BaseEntity{
//	@Column(name = "country" , nullable= false , unique = true)
//	private String country;
	
	
	@Column(nullable = false)
	private String city;
	
	@ManyToOne
	@JoinColumn(name = "country_id" , nullable = false)
	private Country country;
	
	@OneToMany(mappedBy = "country")
	private List<Destination> destinations;

}
