package calculate.interest;

import java.text.NumberFormat;
import java.util.Scanner;

public class CalculateInterest {
    public static void main(String[] args) {
        final byte Months_In_Year = 12;
        final byte Percent = 100;
        int principal = 0;
        float monthlyInterest = 0;
        int numberOfMonths_or_numberOfPayments = 0;
        String repeat = "";

        Scanner input = new Scanner(System.in);
        try {
            while (!repeat.equals("no")) {
                while (true) {
                    System.out.print("Principal: ");
                    principal = input.nextInt();
                    if (principal >= 1000 && principal <= 1_000_000)
                        break;
                    System.out.println("Enter a value between 100 to 1000000");
                }

                while (true) {

                    System.out.print("Annual interest rate: ");
                    float annualInterest = input.nextFloat();
                    if (annualInterest >= 1 && annualInterest <= 30) {
                        monthlyInterest = annualInterest / Percent / Months_In_Year;
                        break;
                    }
                    System.out.println("Enter a value from between 1 and 30");
                }

                while (true) {
                    System.out.print("Period (Years): ");
                    int years = input.nextInt();
                    if (years >= 1 && years <= 30) {
                        numberOfMonths_or_numberOfPayments = years * Months_In_Year;
                        break;
                    }
                    System.out.println("Enter a value from between 1 and 30");
                }

                double mortage = principal
                        * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfMonths_or_numberOfPayments))
                        / (Math.pow(1 + monthlyInterest, numberOfMonths_or_numberOfPayments) - 1);

                String mortageFormatted = NumberFormat.getCurrencyInstance().format(mortage);
                System.out.print("Mortage : " + mortageFormatted);

                System.out.print(" \nDo you want to calculate next mortage (yes/no): ");
                repeat = input.next().toLowerCase();
                System.out.println("\n");
            }

        } finally {
            input.close();
        }
    }
}
