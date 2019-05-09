package angular.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PatchStylo {
	
	private String color;
	
	private int number;

	public PatchStylo(String color, int number) {
		super();
		this.color = color;
		this.number = number;
	}

}
