package main;

import model.Employee;
import model.Office;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Office office = new Office();
        boolean a = true;
        while (a) {
            System.out.println("Menu:");
            System.out.println("1. Insert Data");
            System.out.println("2. View Data");
            System.out.println("3. Update Data");
            System.out.println("4. Delete Data");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    insertData(office, scanner);
                    break;
                case 2:
                    office.viewData();
                    break;
                case 3:
                    office.updateData();
                    break;
                case 4:
                    office.deleteEmployee();
                    break;
                case 5:
                    a = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        scanner.close();
    }

    private static void insertData(Office office, Scanner scanner) {
        System.out.print("Input nama karyawan [>= 3]: ");
        String name = scanner.nextLine();
        System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
        String gender = scanner.nextLine();
        System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
        String position = scanner.nextLine();
        Employee newEmployee = new Employee(name, gender, position);
        office.addEmployee(newEmployee);
        System.out.println("Karyawan berhasil ditambahkan.");
    }
}