package baloro;

import java.util.HashSet;
import java.util.Scanner;

class Salary {
    public void getSalary(Scanner sc) {
        salaries[] sr = new salaries[100];
        HashSet<Integer> existingIds = new HashSet<>();

        System.out.print("Enter number of employees: ");
        int em = sc.nextInt();
        sc.nextLine();
        
        for (int i = 0; i < em; i++) {
            System.out.println("Details of EMP " + (i + 1));
            int id;
            while (true) {
                System.out.print("ID: ");
                id = sc.nextInt();
                sc.nextLine();

                
                if (existingIds.contains(id)) {
                    System.out.println("Error: ID " + id + " is already taken. Please enter a different ID.");
                } else {
                    existingIds.add(id); 
                    break; 
                }
            }

            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Rate(Hour): ");
            double rate = sc.nextDouble();
            System.out.print("Hours worked: ");
            int hour = sc.nextInt();
            System.out.print("Total deduction: ");
            double deduction = sc.nextDouble();
            
            sr[i] = new salaries();
            sr[i].addSalary(id, name, rate, hour, deduction);
            System.out.println("");
        }
        
        double Tsalary = 0, Tdeduction = 0, Tnetpay = 0;

        System.out.println("\n|EMP ID     |Name       |Rate       |Hours      |Gross      |Deductions|");
        for (int i = 0; i < em; i++) {
            Tsalary += sr[i].gross;
            Tdeduction += sr[i].deduct;
            Tnetpay += sr[i].netpay;
            sr[i].getSalary();
        }
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Total salary for request: " + Tsalary);
        System.out.println("Total deductions: " + Tdeduction);
        System.out.println("Total salary to release: " + Tnetpay);
    }
}
