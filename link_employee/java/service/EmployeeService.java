package service;

import domain.Employee;
import domain.EmployeeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    List<EmployeeDTO> getAllEmployees();
    List<EmployeeDTO> getEmployeeByAge(String age);

}
