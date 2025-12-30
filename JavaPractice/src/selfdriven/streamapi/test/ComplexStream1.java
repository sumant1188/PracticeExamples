package test;

import java.util.*;
import java.util.stream.Collectors;

public class ComplexStream1 {
    public static void main(String[] args) {
        Employee e = new Employee();
        List<Employee> employees = e.createEmployees();

        // Group employees by a field
        callGroupByFieldExample(employees);
        // count by gender employees
        callGroupByAndCountByGender(employees);
        // count of male and female present in each department
        callGroupByGenderAndDepartment(employees);
        // oldest employee in the organisation
        callOldestEmployee(employees);
        // Average age of Male and Female Employees in the organisation
        callAverageAgeInOrgByGender(employees);
        // Average age of Male and Female Employees in each department
        callAverageAgeInDeptByGender(employees);
        // longest serving employees in the organization
        callLongestServingEmployee(employees);
        // employees whose age is greater than 30 and less than 30.
        callAgeWiseEmployeeList(employees);
        // Find if there any employees from HR Department
        callCheckIfEmployeeExist(employees);
        // department names that the employees work for, having employees over <given number>
        callDepartmentWithMoreThanSpecifiedEmployeeCount(employees);
        // Sorting a Stream by age and name fields.
        callSortByAgeAndName(employees);
        // Sort employees by salary in descending order. If two employees have the same salary, sort them by age in ascending order
        callSortingBySalaryAndAge(employees);
        // list of employees from each department whose salary is greater than the average salary of their department
        callFindEmployeeWithSalaryMoreThanAverage(employees);

    }

    private static void callFindEmployeeWithSalaryMoreThanAverage(List<Employee> employees) {
        Map<String, Double> averageSalary = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        List<Employee> employeeList = employees.stream()
                .filter(emp -> emp.getSalary() > averageSalary.get(emp.getSalary()))
                .toList();
        employeeList.forEach(System.out::println);
    }

    private static void callSortingBySalaryAndAge(List<Employee> employees) {
        List<Employee> employeeList = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary, Comparator.reverseOrder())
                        .thenComparing(Comparator.comparing(Employee::getAge, Comparator.naturalOrder())))
                .toList();
        employeeList.forEach(System.out::println);
    }

    private static void callGroupByFieldExample(List<Employee> employees) {
        Map<String, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        collect.entrySet().forEach(System.out::println);

    }

    private static void callGroupByAndCountByGender(List<Employee> employees) {
        Map<String, Long> collect = employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        collect.entrySet().forEach(System.out::println);
    }

    private static void callGroupByGenderAndDepartment(List<Employee> employees) {
        Map<String, Map<String, Long>> result = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.groupingBy(Employee::getGender, Collectors.counting())));
        result.forEach((department, genderMap) -> {
            System.out.print("Department: " + department + "==");
            genderMap.forEach((gender, count) ->
                    System.out.print("  " + gender + " -> " + count +", ")
            );
        });
    }

    private static void callOldestEmployee(List<Employee> employees) {
        // Sol-1 sorting
        Optional<Employee> first = employees.stream().sorted(Comparator.comparing(Employee::getAge, Comparator.reverseOrder())).findFirst();
        System.out.println("\n");
        System.out.println("By Sorted method -> " + first.get());

        // Sol-2 max
        Employee employee = employees.stream().max(Comparator.comparingInt(Employee::getAge)).orElse(null);
        System.out.println("By Max method ->" + employee);

        // Sol-3 collector.maxby
        Optional<Employee> result = employees.stream().collect(Collectors.maxBy(Comparator.comparingInt(Employee::getAge)));
        System.out.println("By Collectors Max method ->" + result.get());
    }

    private static void callAverageAgeInOrgByGender(List<Employee> employees) {
        employees.stream()
                 .collect(Collectors.groupingBy(Employee::getGender,
                         Collectors.averagingInt(Employee::getAge)))
                 .entrySet().forEach(System.out::println);
    }

    private static void callAverageAgeInDeptByGender(List<Employee> employees) {
        Map<String, Map<String, Double>> result = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge))));
        result.forEach((department, genderMap) -> {
            System.out.print("Department: " + department + "==");
            genderMap.forEach((gender, average) ->
                    System.out.print("  " + gender + " -> " + average +", ")
            );
        });
    }

    private static void callLongestServingEmployee(List<Employee> employees) {
        Optional<Employee> longestServingEmployee = employees.stream().min(Comparator.comparing(Employee::getJoiningDate));
        System.out.println("\n");
        System.out.println(longestServingEmployee.get());
    }

    private static void callAgeWiseEmployeeList(List<Employee> employees) {
        Map<Boolean, List<Employee>> collect = employees.stream()
                .collect(Collectors.partitioningBy(employee -> employee.getAge() >= 30));
        System.out.println("greater than or equal 30 -> " + collect.get(true));
        System.out.println("less than 30 -> " + collect.get(false));
    }

    private static void callCheckIfEmployeeExist(List<Employee> employees) {
        // Sol 1 - use entire list
        long start = System.currentTimeMillis();
        long hrCount = employees.stream().filter(emp -> "HR".equalsIgnoreCase(emp.getDepartment())).count();
        System.out.println((hrCount > 0)?"exists":"not exists");
        long end = System.currentTimeMillis();
        System.out.println("Time taken filter: " + (end - start) + " ms");

        // sol 2 - anyMatch
        start = System.currentTimeMillis();
        boolean b = employees.stream().anyMatch(employee -> "HR".equalsIgnoreCase(employee.getDepartment()));
        System.out.println(b);
        end = System.currentTimeMillis();
        System.out.println("Time taken any match: " + (end - start) + " ms");

        //sol 3 - find first
        start = System.currentTimeMillis();
        Optional<Employee> first = employees.stream().filter(employee -> "HR".equalsIgnoreCase(employee.getDepartment())).findFirst();
        System.out.println((first.isPresent())?"exists":"Not exists");
        end = System.currentTimeMillis();
        System.out.println("Time taken find first: " + (end - start) + " ms");
    }

    private static void callDepartmentWithMoreThanSpecifiedEmployeeCount(List<Employee> employees) {
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 3)
                .forEach(entry -> System.out.println(entry.getKey()));
    }
    
    private static void callSortByAgeAndName(List<Employee> employees) {
        List<Employee> employeeList = employees.stream()
                .sorted(Comparator.comparingInt(Employee::getAge).thenComparing(Comparator.comparing(Employee::getName)))
                .toList();
        System.out.println(employeeList);
    }

}


