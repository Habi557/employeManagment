package com.employemanagment.serviceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.employemanagment.dto.Employee;
import com.employemanagment.services.EmployeService;
@Service
public class EmployeeServiceImpl  implements  EmployeService{

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return EmployeeServiceImpl.listOfEmployes();
	}
	
	@Override
	public  Employee updateEmploye(int id) {
		// TODO Auto-generated method stub
		Employee employee = EmployeeServiceImpl.listOfEmployes().get(id);
		
		return employee;
	}
	public static List<Employee> listOfEmployes(){
		List<Employee> list = new ArrayList();
		list.add(new Employee(0,"Habibulla","shaik","habi@gmail.com"));
		list.add(new Employee(1,"Abdulla","shaik","abdulla@gmail.com"));
		list.add(new Employee(2,"venkat","pvr","venk@gmail.com"));
		list.add(new Employee(3,"venu","ve","venu@gmail.com"));
		list.add(new Employee(4,"Dileep","de","deelip@gmail.com"));
//		list.add(new Employee(5,"vihari","vi","vihari@gmail.com"));
//		list.add(new Employee(6,"Test1","t1","Test1@gmail.com"));
//		list.add(new Employee(7,"Test2","t2","Test2@gmail.com"));
//		list.add(new Employee(8,"Test3","t3","Test3@gmail.com"));
//		list.add(new Employee(9,"Test4","t4","Test4@gmail.com"));
//
//
		return list;
	}

}
