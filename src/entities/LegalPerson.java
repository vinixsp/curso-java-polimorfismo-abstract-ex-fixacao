package entities;

public class LegalPerson extends Person {

	private Integer employeesNumber;
	
	public LegalPerson() {
		super();
	}
	
	public LegalPerson(String name, Double annualIncome, Integer employeesNumber) {
		super(name, annualIncome);
		this.employeesNumber = employeesNumber;
	}

	public Integer getEmployeesNumber() {
		return employeesNumber;
	}

	public void setEmployeesNumber(Integer employeesNumber) {
		this.employeesNumber = employeesNumber;
	}

	@Override
	public Double taxDue() {
		double taxPercent = (employeesNumber <= 10) ? 0.16 : 0.14;
		return (annualIncome * taxPercent);
	}

}
