package ua.airlines.Entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.airlines.Entity.Enums.PlaneType;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "plane")
public class Plane extends BaseEntity{
	@ManyToOne
	@JoinColumn(name = "company_id")
	private Aircompany aircompany;
	
	@Enumerated(EnumType.STRING)
	private PlaneType planeType;
}
