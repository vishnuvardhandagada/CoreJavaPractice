package lombok.practice;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

public class Employee {

	@Getter
	private BigDecimal id;

	@Setter
	private String name;

	@Getter
	@Setter
	private LocalDate joiningDate;

	@Setter
	@Getter
	private String designation;

	private BigDecimal salary;
}
