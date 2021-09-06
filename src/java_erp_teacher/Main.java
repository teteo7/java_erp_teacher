package java_erp_teacher;

import java_erp_teacher.dto.Department;
import java_erp_teacher.dto.Employee;
import java_erp_teacher.dto.Title;

public class Main {

	public static void main(String[] args) {
		Employee  emp = new Employee(1004, "천사", null, null, 150000, null);
		Employee  emp1 = new Employee(1004, "천사", new Title(1), null, 150000, null);
		Employee  emp2 = new Employee(1004, "천사", new Title(1), new Employee(1003), 150000, null);
		Employee  emp3 = new Employee(1004, "천사", new Title(1), new Employee(1003), 150000, new Department(1));
		
		Title title = new Title(3, "과장");
		Employee manager = new Employee(1003, "이성례", new Title(1), null, 0, new Department(1));
		Department dept = new Department(2, "영업", 10);
		
		Employee newEmp = new Employee(1004, "현빈", title, manager, 20000000, dept);
		
		
		System.out.println("emp: " + emp);
		System.out.println();
		System.out.println("emp: " + emp1);
		System.out.println();
		System.out.println("emp: " + emp2);
		System.out.println();
		System.out.println("emp: " + emp3);
		
		//1. emp3의 직책
		Title emp3Title = newEmp.getTitle();
		String titleName = newEmp.getTitle().gettName();
		
		System.out.printf("직책 : %s%n",emp3Title);
		System.out.printf("직책명 :%s%n ",titleName);
	}

}
