package com.mannai.controller;

import com.mannai.dto.EmployeeReq;
import com.mannai.dto.EmployeeRes;
import com.mannai.dto.PageRes;
import com.mannai.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.mannai.util.Constant.EMP_API;

@RestController
@RequiredArgsConstructor
@RequestMapping(EMP_API)
public class EmployeeController {

	private final EmployeeService employeeService;

	@PostMapping
	public ResponseEntity<EmployeeRes> addEmployee(@RequestBody @Valid EmployeeReq employeeReq) {
		return new ResponseEntity<>(employeeService.addEmployee(employeeReq), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<EmployeeRes> updateEmployee(@PathVariable Long id,
	                                                  @RequestBody @Valid EmployeeReq employeeReq) {
		return new ResponseEntity<>(employeeService.updateEmployee(id,employeeReq), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<PageRes<EmployeeRes>> getEmployees(
			@RequestParam(defaultValue = "0") Integer pageNumber,
			@RequestParam(defaultValue = "10") Integer pageSize) {
		return new ResponseEntity<>(employeeService
				.getAllEmployees(PageRequest.of(pageNumber, pageSize)), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EmployeeRes> getEmployee(@PathVariable Long id) {
		return new ResponseEntity<>(employeeService
				.getEmployee(id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
		return new ResponseEntity<>(employeeService.deleteEmployee(id), HttpStatus.OK);
	}
}
