package ua.airlines.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name ="air_company")
public class Aircompany extends BaseEntity {
	
		@Column(name = "company_name" , length = 150 , nullable = false)
		private String companyName;
		
		@Column(name = "company_addres" , nullable = false)
		private String companyAddres;

}
