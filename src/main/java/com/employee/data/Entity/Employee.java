package com.employee.data.Entity;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




import lombok.Getter;
import lombok.Setter;


@Entity
@Table

@Getter
@Setter
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long EmployeeId;
	private String surname;
	private String first_name;
	private String location;
	@Override
	public String toString() {
		return "Employee [EmployeeId=" + EmployeeId + ", surname=" + surname + ", first_name=" + first_name
				+ ", location=" + location + "]";
	}
	

}
