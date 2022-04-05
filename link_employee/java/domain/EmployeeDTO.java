package domain;

import lombok.Data;

@Data
public class EmployeeDTO {

    private int id;
    private String name;
    private int age;

    public EmployeeDTO(Employee employee) {
        this.id = employee.getId();
        this.name = employee.getName();
        this.age = employee.getAge();
    }
}
