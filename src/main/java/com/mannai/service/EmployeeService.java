package com.mannai.service;

import com.mannai.dto.EmployeeReq;
import com.mannai.dto.EmployeeRes;
import com.mannai.dto.PageRes;
import com.mannai.exception.EmployeeNotFoundException;
import com.mannai.mapper.EmployeeMapper;
import com.mannai.model.Employee;
import com.mannai.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

	private final EmployeeRepository employeeRepository;

	private final EmployeeMapper employeeMapper;


	public EmployeeRes addEmployee(EmployeeReq employeeReq) {
		return employeeMapper
				.toEmployeeRes(employeeRepository
						.save(employeeMapper.toEmployeeRes(employeeReq)));
	}

	public PageRes<EmployeeRes> getAllEmployees(Pageable pageable) {
		return employeeMapper
				.toEmployeeRes(employeeRepository
						.findAll(pageable));
	}

	public EmployeeRes updateEmployee(Long id, EmployeeReq employeeReq) {

		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));

		employee.setName(employeeReq.name());
		employee.setDepartment(employeeReq.department());
		employee.setSalary(employeeReq.salary());
		return employeeMapper.toEmployeeRes(employeeRepository.save(employee));

	}

	public EmployeeRes getEmployee(Long id) {

		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
		
		return employeeMapper.toEmployeeRes(employee);
	}

	public Void deleteEmployee(Long id) {
		if (!employeeRepository.existsById(id)) {
			throw new EmployeeNotFoundException("Employee not found with id: " + id);
		}
		employeeRepository.deleteById(id);
		return null;
	}
}
