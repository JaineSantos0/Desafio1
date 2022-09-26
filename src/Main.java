import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Renda anual com salário: ");
        double salaryIncome = sc.nextDouble();
        System.out.print("Renda anual com prestação de serviço: ");
        double serviceIncome = sc.nextDouble();
        System.out.print("Renda anual com ganho de capital: ");
        double capitalIncome = sc.nextDouble();
        System.out.print("Gastos médicos: ");
        double medicalExpenses = sc.nextDouble();
        System.out.print("Gastos educacionais: ");
        double educationExpenses = sc.nextDouble();

        System.out.println();
        System.out.println("RELATÓRIO DE IMPOSTO DE RENDA");
        System.out.println();

        double tax;
        double monthlySalaryIncome = salaryIncome/12;
        double taxSalaryIncome;

        if (monthlySalaryIncome > 5000) {
            tax = 0.20;
            taxSalaryIncome = (salaryIncome * tax);
        } else if (monthlySalaryIncome > 3000 && monthlySalaryIncome < 5000) {
            tax = 0.10;
            taxSalaryIncome = (salaryIncome * tax);
        } else {
            tax = 0.00;
            taxSalaryIncome = salaryIncome * tax;
        }

        System.out.println("CONSOLIDADO DE RENDA: ");
        System.out.printf("Imposto sobre salário: %.2f%n",taxSalaryIncome);

        double taxServiceIncome;

        if (serviceIncome > 0) {
            tax = 0.15;
        } else {
            tax = 0.00;
        }
        taxServiceIncome = serviceIncome * tax;

        System.out.printf("Imposto sobre serviços: %.2f%n",taxServiceIncome);

        double taxCapitalIncome;

        if (capitalIncome > 0) {
            tax = 0.20;
            taxCapitalIncome = capitalIncome * tax;
        } else {
            tax = 0.00;
            taxCapitalIncome = capitalIncome * tax;
        }

        System.out.printf("Imposto sobre ganho de capital: %.2f%n",taxCapitalIncome);

        double totalTax = taxSalaryIncome + taxServiceIncome + taxCapitalIncome;
        double deductibleMaxima = totalTax * 0.30;
        double deductibleExpenses = medicalExpenses + educationExpenses;

        System.out.println();
        System.out.println("DEDUÇÕES: ");
        System.out.printf("Máximo dedutível: %.2f%n",deductibleMaxima);
        System.out.printf("Gastos dedutíveis: %.2f%n",deductibleExpenses);

        System.out.println();
        System.out.println("RESUMO: ");

        System.out.printf("Imposto bruto total: %.2f%n",totalTax);

        double taxRebate = Math.min(deductibleExpenses, deductibleMaxima);

        System.out.printf("Abatimento: %.2f%n",taxRebate);

        double taxDue = totalTax - taxRebate;

        System.out.printf("Imposto devido: %.2f%n",taxDue);
    }

}