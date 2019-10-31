package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.IndividualPerson;
import entities.LegalPerson;
import entities.Person;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Person> taxPayers = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int p = sc.nextInt();
		
		for (int i=1; i<=p; i++) {
			System.out.println("Tax payer #" + i + " data:");
			sc.nextLine();
			System.out.print("Individual or Company (i/c)? ");
			char type = sc.nextLine().charAt(0);
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Annual income: ");
			Double annualIncome = sc.nextDouble();
			
			if (type == 'i') {
				System.out.print("Health expenditures: ");
				Double medicalExpenses = sc.nextDouble();
				taxPayers.add(new IndividualPerson(name, annualIncome, medicalExpenses));
			} else {
				System.out.print("Number of employees: ");
				int employeesNumber = sc.nextInt();
				taxPayers.add(new LegalPerson(name, annualIncome, employeesNumber));
			}
		}
		
		System.out.println();
		System.out.println("TAXES PAID:");
		
		Double sum = 0d;
		for (Person person : taxPayers) {
			System.out.println(person.getName() + ": $ " + String.format("%.2f", person.taxDue()));
			sum += person.taxDue();
		}
		
		System.out.println();
		System.out.printf("TOTAL TAXES: $ %.2f\n", sum);
		
		sc.close();
	}

}
