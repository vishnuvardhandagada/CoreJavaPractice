package lombok.practice;

import java.time.LocalDate;
import java.util.Date;

import lombok.Data;

@Data
public class Student {

	private Integer id;
	private String name;
	private String course;
	private LocalDate startDate;
	private Date endDate;
	private Double salary;

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", course=" + course + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", salary=" + salary + "]";
	}

}
