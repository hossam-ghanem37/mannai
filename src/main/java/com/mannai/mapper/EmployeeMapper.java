package com.mannai.mapper;

import com.mannai.dto.EmployeeReq;
import com.mannai.dto.EmployeeRes;
import com.mannai.dto.PageRes;
import com.mannai.model.Employee;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper
public interface EmployeeMapper {


	Employee toEmployeeRes(EmployeeReq employeeReq);
	EmployeeRes toEmployeeRes(Employee employee);
	@IterableMapping(qualifiedByName = "toEmployeeRes")
	PageRes<EmployeeRes> toEmployeeRes(Page<Employee> employeeList);
}
