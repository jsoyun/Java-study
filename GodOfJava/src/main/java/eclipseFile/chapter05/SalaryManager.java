package chapter05;

//5장 다시 풀어보기 ~
public class SalaryManager {
	
	public double getMonthlySalary(int yearlySalary) {
		//yearlySalary 연봉 
		double monthlySalary = yearlySalary /12;
		System.out.println("건강보험료"+calculateHealInsurance( monthlySalary));
		
		double calculateNationalPersion = calculateNationalPersion(monthlySalary);
		double calculateTax = calculateTax(monthlySalary);
		
		monthlySalary -= (calculateNationalPersion +calculateTax +calculateHealInsurance( monthlySalary));
		
		//리턴값은 월급여  
		return monthlySalary;
		
	}
	
	public double calculateTax(double monthlySalary) {
		double tax = (monthlySalary * 0.125);
		return tax;
	}
	public double calculateNationalPersion(double monthlySalary) {
		return monthlySalary * 0.081;
	}
	public double calculateHealInsurance(double monthlySalary) {
		return monthlySalary * 0.081;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SalaryManager salary = new SalaryManager();
		double monthlySalary = salary.getMonthlySalary(2000);
//		salary.calculateTax(monthlySalary);
		
		
		

	}

}
