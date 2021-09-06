package java_erp_teacher.dao;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java_erp_teacher.dao.impl.EmployeeDaoImpl;
import java_erp_teacher.dto.Department;
import java_erp_teacher.dto.Employee;
import java_erp_teacher.dto.Title;


public class EmployeeDaoTest {
	private EmployeeDao dao= EmployeeDaoImpl.getInstance();

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void testSelectEmployeeAll() {
		System.out.println("testSelectEmployeeByAll()");
		ArrayList<Employee> list = dao.selectEmployeeAll();
		Assert.assertNotEquals(0, list.size());
		list.stream().forEach(System.out::println);
	}

	@Test
	public void testSelectEmployeeByNo() {
		System.out.println("testSelectEmployeeByNo()");
		Employee selectEmp = dao.selectEmployeeByNo(new Employee(4377)); 
		Assert.assertNotNull(selectEmp); 
		System.out.println(selectEmp); 
	}
//////////////////////////////////////////////
	@Test
	public void test01InsertDepartment() {
		System.out.println("test01InsertEMployee()");
		Employee newEmp= new Employee(1010, "신혜리", null, null, 2500000, null);
		int res = dao.insertEmployee(newEmp);
		Assert.assertEquals(1, res);
		dao.deleteEmployee(newEmp);
	}
	
	@Test
	public void test02InsertDepartment() {
		System.out.println("test02InsertEMployee()");
		Title title = new Title(2);
		Employee newEmp = new Employee(1011, "신혜리1", title, null, 2500000, null);
		int res = dao.insertEmployee(newEmp);
		Assert.assertEquals(1, res);
		dao.deleteEmployee(newEmp);
	}
	
	@Test
	public void test03InsertDepartment() {
		System.out.println("test03InsertEMployee()");
		Title title = new Title(2);
		Employee manager = new Employee(4377);
		Employee newEmp = new Employee(1012, "신혜리2", title, manager, 2500000, null);
		int res = dao.insertEmployee(newEmp);
		Assert.assertEquals(1, res);
		dao.deleteEmployee(newEmp);
	}
	
	@Test
	public void test04InsertDepartment() {
		System.out.println("test04InsertEMployee()");
		Title title = new Title(2);
		Employee manager = new Employee(4377);
		Department dno = new Department(1);
		Employee newEmp = new Employee(1013, "신혜리3", title , manager, 2500000, dno);
		int res = dao.insertEmployee(newEmp);
		Assert.assertEquals(1, res);
		dao.deleteEmployee(newEmp);
	}
////////////////////////////////////////////

	@Test
	public void test01UpdateDepartment() {
		System.out.println("test01UpdateDepartment()");
		Employee newEmp= new Employee(1014, "신혜리", null, null, 2500000, null);
		dao.insertEmployee(newEmp);
		
		//수정
		newEmp.setEmpName("최명기");
		newEmp.setSalary(1500000);
		int res= dao.updateEmployee(newEmp);
		Assert.assertEquals(1, res);
		
		dao.deleteEmployee(newEmp);
	}
	
	@Test
	public void test02UpdateDepartment() {
		System.out.println("test02UpdateDepartment()");
		Title title = new Title(2);
		Employee manager = new Employee(4377);
		Department dno = new Department(1);
		Employee newEmp = new Employee(1015, "신혜리3", title , manager, 2500000, dno);
		dao.insertEmployee(newEmp);
		
		//수정
		newEmp.setTitle(new Title(1));
		newEmp.setManager(new Employee(1005));
		newEmp.setDept(new Department(2));
		int res= dao.updateEmployee(newEmp);
		Assert.assertEquals(1, res);
		dao.deleteEmployee(newEmp);
	}

	@Test
	public void testDeleteDepartment() {
		System.out.println("testDeleteDepartment()");
		Employee newEmp= new Employee(1010, "신혜리", null, null, 2500000, null);
		dao.insertEmployee(newEmp);
		
		int res= dao.deleteEmployee(newEmp);
		Assert.assertEquals(1, res);
	}

}
