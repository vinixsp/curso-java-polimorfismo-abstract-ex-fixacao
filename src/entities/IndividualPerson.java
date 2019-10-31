package entities;

public class IndividualPerson extends Person {

	private Double medicalExpenses = 0d;
	
	public IndividualPerson() {
		super();
	}
	
	public IndividualPerson(String name, Double annualIncome, Double medicalExpenses) {
		super(name, annualIncome);
		this.medicalExpenses = medicalExpenses;
	}

	public Double getMedicalExpenses() {
		return medicalExpenses;
	}

	public void setMedicalExpenses(Double medicalExpenses) {
		this.medicalExpenses = medicalExpenses;
	}

	@Override
	public Double taxDue() {
		double taxPercent = (annualIncome < 20000.00) ? 0.15 : 0.25;
		return (annualIncome * taxPercent) - (medicalExpenses * 0.5);
	}
}
