package selfdriven.streamapi.test;

import java.time.LocalDate;
import java.util.List;

public class Employee {

    private int id;
    private String name;
    private int age;
    private double salary;
    private String department;
    private String gender;
    private LocalDate joiningDate;

    public Employee(int id, String name, int age, double salary, String department, String gender, LocalDate joiningDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
        this.gender = gender;
        this.joiningDate = joiningDate;
    }

    public Employee(){

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                ", gender='" + gender + '\'' +
                ", joiningDate=" + joiningDate +
                '}';
    }

    public List<Employee> createEmployees() {
        return List.of(
                        new Employee(1,  "Amit",    26, 50000, "IT",      "Male",   LocalDate.of(2020, 1, 15)),
                        new Employee(2,  "Neha",    27, 60000, "HR",      "Female", LocalDate.of(2019, 3, 10)),
                        new Employee(3,  "Rahul",   28, 50000, "IT",      "Male",   LocalDate.of(2021, 6, 5)),
                        new Employee(4,  "Priya",   29, 70000, "Finance", "Female", LocalDate.of(2018, 8, 20)),
                        new Employee(5,  "Vikas",   30, 60000, "HR",      "Male",   LocalDate.of(2017, 11, 12)),
                        new Employee(6,  "Anjali",  31, 80000, "IT",      "Female", LocalDate.of(2022, 2, 1)),
                        new Employee(7,  "Rohit",   32, 70000, "Finance", "Male",   LocalDate.of(2016, 9, 18)),
                        new Employee(8,  "Sneha",   33, 50000, "IT",      "Female", LocalDate.of(2020, 5, 25)),
                        new Employee(9,  "Karan",   34, 90000, "Sales",   "Male",   LocalDate.of(2015, 4, 14)),
                        new Employee(10, "Pooja",   35, 60000, "HR",      "Female", LocalDate.of(2019, 7, 8)),
                        new Employee(11, "Suresh",  36, 80000, "IT",      "Male",   LocalDate.of(2014, 12, 3)),
                        new Employee(12, "Meena",   37, 70000, "Finance", "Female", LocalDate.of(2018, 1, 19)),
                        new Employee(13, "Arjun",   38, 90000, "Sales",   "Male",   LocalDate.of(2016, 6, 30)),
                        new Employee(14, "Kavita",  39, 50000, "Support", "Female", LocalDate.of(2021, 10, 9)),
                        new Employee(15, "Nikhil",  40, 60000, "Support", "Male",   LocalDate.of(2017, 2, 27)),
                        new Employee(16, "Divya",   41, 80000, "IT",      "Female", LocalDate.of(2013, 3, 16)),
                        new Employee(17, "Manish",  42, 70000, "Finance", "Male",   LocalDate.of(2012, 8, 6)),
                        new Employee(18, "Ritu",    43, 90000, "Sales",   "Female", LocalDate.of(2014, 11, 21)),
                        new Employee(19, "Deepak",  44, 50000, "HR",      "Male",   LocalDate.of(2011, 5, 2)),
                        new Employee(20, "Shalini", 45, 60000, "IT",      "Female", LocalDate.of(2010, 9, 13))
        );
    }
}
