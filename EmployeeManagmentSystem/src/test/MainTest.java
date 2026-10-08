/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import model.CommissionEmployee;
import model.Department;
import model.Employee;
import model.Gender;
import model.HourlyEmployee;
import model.MonthlyEmployee;

import java.time.LocalDate;
import java.util.ArrayList;

public class MainTest {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("   EMPLOYEE MANAGEMENT SYSTEM");
        System.out.println("========================================");

        // ----------------------------------------
        // 1. Create Commission Employee
        // ----------------------------------------

        CommissionEmployee commissionEmployee =
                new CommissionEmployee(
                        1,
                        "Ahmed",
                        Gender.MALE,
                        LocalDate.of(2024, 1, 15),
                        10000,
                        0.05,
                        50000
                );

        // ----------------------------------------
        // 2. Create Monthly Employee
        // ----------------------------------------

        MonthlyEmployee monthlyEmployee =
                new MonthlyEmployee(
                        2,
                        "Mariam",
                        Gender.FEMALE,
                        LocalDate.of(2023, 6, 10),
                        12000,
                        24,
                        0.10,
                        true
                );

        // ----------------------------------------
        // 3. Create Hourly Employee
        // ----------------------------------------

        HourlyEmployee hourlyEmployee =
                new HourlyEmployee(
                        3,
                        "Omar",
                        Gender.MALE,
                        LocalDate.of(2025, 3, 1),
                        100,
                        45,
                        1.5
                );

        // ----------------------------------------
        // 4. Create Department
        // ----------------------------------------

        Department department =
                new Department(
                        101,
                        "Information Technology",
                        monthlyEmployee,
                        new ArrayList<>()
                );

        // ----------------------------------------
        // 5. Add Employees
        // ----------------------------------------

        department.addEmployee(commissionEmployee);
        department.addEmployee(monthlyEmployee);
        department.addEmployee(hourlyEmployee);

        // ----------------------------------------
        // 6. Print Employees
        // ----------------------------------------

        System.out.println();
        department.printAllEmployees();

        // ----------------------------------------
        // 7. Calculate Salaries
        // ----------------------------------------

        System.out.println();
        System.out.println("========================================");
        System.out.println("SALARY INFORMATION");
        System.out.println("========================================");

        System.out.println(
                "Commission Employee Salary: "
                + commissionEmployee.calculateSalary());

        System.out.println(
                "Monthly Employee Salary: "
                + monthlyEmployee.calculateSalary());

        System.out.println(
                "Hourly Employee Salary: "
                + hourlyEmployee.calculateSalary());

        // ----------------------------------------
        // 8. Commission
        // ----------------------------------------

        System.out.println();
        System.out.println(
                "Commission: "
                + commissionEmployee.calculateCommission());

        // ----------------------------------------
        // 9. Additional Vacation
        // ----------------------------------------

        System.out.println(
                "Additional Vacation: "
                + monthlyEmployee.calculateAdditionalVacation());

        // ----------------------------------------
        // 10. Total Payroll
        // ----------------------------------------

        System.out.println();
        System.out.println(
                "Total Department Payroll: "
                + department.calculateTotalPayroll());

        // ----------------------------------------
        // 11. Find Employee
        // ----------------------------------------

        System.out.println();
        System.out.println("========================================");
        System.out.println("SEARCH EMPLOYEE");
        System.out.println("========================================");

        Employee foundEmployee =
                department.findEmployee(2);

        if (foundEmployee != null) {

            System.out.println("Employee Found:");
            System.out.println(foundEmployee);

        } else {

            System.out.println("Employee Not Found.");
        }

        // ----------------------------------------
        // 12. Department Information
        // ----------------------------------------

        System.out.println();
        System.out.println("========================================");
        System.out.println("DEPARTMENT INFORMATION");
        System.out.println("========================================");

        System.out.println(department);

        System.out.println(
                "Manager: "
                + department.getManager().getName());

        // ----------------------------------------
        // 13. Test Getter
        // ----------------------------------------

        System.out.println();
        System.out.println(
                "Employee 1 Name: "
                + commissionEmployee.getName());

        // ----------------------------------------
        // 14. Test Setter
        // ----------------------------------------

        commissionEmployee.setName("Ahmed Ali");

        System.out.println(
                "Updated Employee 1 Name: "
                + commissionEmployee.getName());

        // ----------------------------------------
        // 15. Test Remove Employee
        // ----------------------------------------

        department.removeEmployee(3);

        System.out.println();
        System.out.println(
                "After removing employee with ID 3:");

        department.printAllEmployees();

        // ----------------------------------------
        // 16. Final Payroll
        // ----------------------------------------

        System.out.println();
        System.out.println(
                "Final Department Payroll: "
                + department.calculateTotalPayroll());

        System.out.println();
        System.out.println("========================================");
        System.out.println("PROGRAM FINISHED SUCCESSFULLY");
        System.out.println("========================================");
    }
}