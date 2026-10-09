/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private int id;
    private String name;
    private Employee manager;
    private List<Employee> employees;

    public Department(
            int id,
            String name,
            Employee manager,
            List<Employee> employees) {

        this.id = id;
        this.name = name;
        this.manager = manager;

        if (employees == null) {
            this.employees = new ArrayList<>();
        } else {
            this.employees = employees;
        }

        if (manager != null) {
            manager.setDepartment(this);
        }

        for (Employee employee : this.employees) {
            employee.setDepartment(this);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;

        if (manager != null) {
            manager.setDepartment(this);
        }
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {

        if (employees == null) {
            this.employees = new ArrayList<>();
        } else {
            this.employees = employees;
        }

        for (Employee employee : this.employees) {
            employee.setDepartment(this);
        }
    }

    public void addEmployee(Employee employee) {

        if (employee != null && !employees.contains(employee)) {
            employees.add(employee);
            employee.setDepartment(this);
        }
    }

    public void removeEmployee(int employeeId) {

        Employee employee = findEmployee(employeeId);

        if (employee != null) {
            employees.remove(employee);
            employee.setDepartment(null);
        }
    }

    public Employee findEmployee(int employeeId) {

        for (Employee employee : employees) {

            if (employee.getId() == employeeId) {
                return employee;
            }
        }

        return null;
    }

    public double calculateTotalPayroll() {

        double total = 0;

        for (Employee employee : employees) {
            total += employee.calculateSalary();
        }

        return total;
    }

    public void printAllEmployees() {

        System.out.println(
                "Employees in Department: " + name);

        System.out.println(
                "========================================");

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Override
    public String toString() {

        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manager=" +
                (manager != null
                        ? manager.getName()
                        : "None") +
                ", employeesCount=" +
                employees.size() +
                '}';
    }
}