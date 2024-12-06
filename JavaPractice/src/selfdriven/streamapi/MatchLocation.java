package selfdriven.streamapi;

import java.util.List;
import java.util.stream.Collectors;

public class MatchLocation {

    public static void main(String[] args) {
        List<Employee> employees = SortingOnObjects.createEmployees();
        List<Employee> employeesWithMatchedCity = employees.stream()
                .filter(e -> e.getLocations().stream()
                        .anyMatch(location -> location.getCity().equals("Bangalore")))
                .toList();
        System.out.println(employeesWithMatchedCity.size());
        System.out.println(employeesWithMatchedCity);
    }
}
