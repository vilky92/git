package angular.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Stylo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty
	//@Size(min=1, max=20)
	private String color;
	
	@NotNull
	@Min(1)
	@Max(100)
	private int number;

	public Stylo(@NotEmpty @Size(min = 1, max = 20) String color, @NotNull @Min(1) @Max(100) int number) {
		this.color = color;
		this.number = number;
	}

	public Stylo() {
	}

	
	
}
