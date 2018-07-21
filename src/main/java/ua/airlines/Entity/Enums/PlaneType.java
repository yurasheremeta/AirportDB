/**
 * 
 */
package ua.airlines.Entity.Enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PlaneType {
	
	BOEING_737_200("BOEING 737" , 200),
	AIRBUS_A220_180("BOEING 737" , 180),
	BOEING_777_190("BOEING 737" , 190);
	
	private String name;
	private int seetsNumber;

}
