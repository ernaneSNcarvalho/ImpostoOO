package Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Quantos contribuintes voce vai digitar? ");
		int n = sc.nextInt();
		List<TaxPayer> list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			System.out.println("Digite os dados do " + (1+i) + "o contribuinte: ");
			System.out.print("Renda anual com salario: ");
			double salaryIncome = sc.nextDouble();
			System.out.print("Renda anual com prestacao de servico: ");
			double serviceIncome = sc.nextDouble();
			System.out.print("Renda anual com ganho de capital: ");
			double capitalIncome = sc.nextDouble();
			System.out.print("Gastos medicos: ");
			double healthSpending = sc.nextDouble();
			System.out.print("Gastos educacionais: ");
			double educationSpending = sc.nextDouble();
			list.add(new TaxPayer(salaryIncome, serviceIncome, capitalIncome, healthSpending, educationSpending));
			
		}
		
		int i = 1;
		for(TaxPayer p : list) {
			System.out.println("Resumo do " + i + "o contribuinte: ");
			System.out.printf("Imposto bruto total: %.2f%n", p.grossTax());
			System.out.printf("Abatimento: %.2f%n", p.taxRebate());
			System.out.printf("Imposto devido: %.2f%n", p.netTax());
			i++;
		}
		
		sc.close();
	}

}
