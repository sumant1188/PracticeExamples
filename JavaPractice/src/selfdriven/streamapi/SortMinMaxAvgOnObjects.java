package selfdriven.streamapi;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SortMinMaxAvgOnObjects {
    public static void main(String[] args) {
        List<Employee> empList = createEmployees();
        List<Employee> list = empList.stream().filter(Objects::nonNull)
                .sorted(Comparator.comparing(Employee::getSalary))
                .toList();
        System.out.println(list);

        // averaging salary
        Double averageSalary = empList.stream().collect(Collectors.averagingInt(Employee::getSalary));
        System.out.println(averageSalary);
    }
    public static List<Employee> createEmployees() {
        List<Location> multiCity = List.of(
                new Location("Pune", "Maharashtra", "India"),
                new Location("Bangalore", "Karnataka", "India"),
                new Location("Hyderabad", "Telangana", "India")
        );
        List<Location> bangCity = List.of(
                new Location("Bangalore", "Karnataka", "India")
        );
        List<Location> puneCity = List.of(
                new Location("Pune", "Maharashtra", "India")
        );
        List<Location> hybdCity = List.of(
                new Location("Hyderabad", "Telangana", "India")
        );

        return List.of(
                new Employee(1, "emp1", 20000, multiCity),
                new Employee(2, "emp1", 15000, hybdCity),
                new Employee(3, "emp3", 30000, bangCity),
                new Employee(4, "emp4", 100000, puneCity)
        );
    }
}

class Employee {
    private int id;
    private String name;
    private int salary;
    private List<Location> locations;

    public Employee(int id, String name, int salary, List<Location> locations) {
        this.id = id;
        this.locations = locations;
        this.salary = salary;
        this.name = name;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && salary == employee.salary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", locations=" + locations +
                '}';
    }
}

class Location {
    private String city;
    private String state;
    private String country;

    @Override
    public String toString() {
        return "Location{" +
                "city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public Location(String city, String state, String country) {
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }
}
