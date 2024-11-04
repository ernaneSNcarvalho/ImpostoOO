package Entities;

public class TaxPayer {
	private Double salaryIncome;
	private Double serviceIncome;
	private Double capitalIncome;
	private Double healthSpending;
	private Double educationSpending;
	
	public TaxPayer(
			Double salaryIncome, 
			Double serviceIncome, 
			Double capitalincome, 
			Double healthSpending,
			Double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.serviceIncome = serviceIncome;
		this.capitalIncome = capitalincome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}

	public Double getSalaryIncome() {
		return salaryIncome;
	}

	public Double getServiceIncome() {
		return serviceIncome;
	}

	public Double getCapitalincome() {
		return capitalIncome;
	}

	public Double getHealthSpending() {
		return healthSpending;
	}

	public Double getEducationSpending() {
		return educationSpending;
	}
	
	public double salaryTax() {
		double tax = 0.0;
		double salary = salaryIncome / 12.0;
		if(salary < 3.000) {
			return 0.0;
		}else if(salary >= 3000.0 && salary < 5000.0) {
			return tax = salaryIncome * 0.10;
		}else if(salary >= 5000.0) {
			return tax = salaryIncome * 0.20;
		}
		return tax;
	}
	
	public double servicesTax() {
		return serviceIncome * 0.15;
	}
	
	public double capitalTax() {
		return capitalIncome * 0.20;
	}
	
	public double grossTax() {
		return salaryTax() + servicesTax() + capitalTax();
	}
	
	public double taxRebate() {
		double value = grossTax() * 0.30;
		if(healthSpending + educationSpending < value) {
			return healthSpending + educationSpending;
		}else {
			return value;
		}
	}
	
	public double netTax() {
		return grossTax() - taxRebate();
	}	
}
