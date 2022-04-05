package domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
@Table(name = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private String age;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    private List<Employee> employeeList = new ArrayList<>();
    
    @Transactional
    public Map<String, List<Employee>> getAllEmployees() {
        Map<String, List<Employee>> getEmployeeName = employeeList.stream().collect(Collectors.groupingBy(Employee :: getAge));
        return getEmployeeName;
    }
    @Transactional
    public List<Employee> getEmployeeByAge(String age) {
        List<Employee> emp = employeeList.stream().filter(e -> e.age == age).collect(Collectors.toList());
        return emp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && name.equals(employee.name) && age.equals(employee.age) && employeeList.equals(employee.employeeList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, employeeList);
    }


}










