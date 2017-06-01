package pl.raziel.spring.data.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue
	private Long id;
	private String firstName;
	private String lastName;
	private String BigDecimal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBigDecimal() {
		return BigDecimal;
	}

	public void setBigDecimal(String bigDecimal) {
		BigDecimal = bigDecimal;
	}


	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Employee{");
		sb.append("id=").append(id);
		sb.append(", firstName='").append(firstName).append('\'');
		sb.append(", lastName='").append(lastName).append('\'');
		sb.append(", BigDecimal='").append(BigDecimal).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
