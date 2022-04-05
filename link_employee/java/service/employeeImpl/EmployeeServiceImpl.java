package service.employeeImpl;

import domain.Employee;
import domain.EmployeeDTO;
import exception.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.EmployeeService;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private Employee employee;

    @Autowired // inject bean
    public EmployeeServiceImpl(Employee employee) {
        this.employee = employee;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        Collection<Employee> employees = employee.getEmployeeList();
        return employees.stream().map(s -> new EmployeeDTO(s)).collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDTO> getEmployeeByAge(String age) {
        Employee employees = (Employee) employee.getEmployeeByAge(age);
        if(employees == null) {
            throw new EmployeeNotFoundException("Can not find employee");
        }
        return new EmployeeDTO(employee.getAge(age));
    }

}
