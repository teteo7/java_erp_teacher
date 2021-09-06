package java_erp_teacher.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java_erp_teacher.dao.DepartmentDao;
import java_erp_teacher.dto.Department;
import java_erp_teacher.util.JdbcUtil;

public class DepartmentDaoImpl implements DepartmentDao {

	private static final DepartmentDaoImpl instance = new DepartmentDaoImpl();

	public static DepartmentDaoImpl getInstance() {
		return instance;
	}

	public DepartmentDaoImpl() {
	}

	@Override
	public ArrayList<Department> selectDepartmentByAll() {
		String sql = "select deptno ,deptname ,floor from department";
		ArrayList<Department> list = null;

		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			list = new ArrayList<Department>();
			while (rs.next()) {
				// deptno ,deptname ,floor
				list.add(getDepartment(rs)); // ArrayList에 넣기
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	private Department getDepartment(ResultSet rs) throws SQLException {
		// deptno ,deptname ,floor
		int deptNo = rs.getInt("deptno");
		String deptName = rs.getString("deptname");
		int floor = rs.getInt("floor");
		Department newDept = new Department(deptNo, deptName, floor);// 클래스 생성
		return newDept;
	}

	@Override
	public Department selectDepartmentByNo(Department department) {
		/*
		 * 1.db접속(시간많이 걸림) <- Connection pool = Connection 
		 * 2.sql을 데이터베이스에 맞는 코드로준비(스트링을
		 * 명령문으로 변경) = PreparedStatement 
		 * 3.sql에서 ?를 입력 매개변수값으로 치환해서 sql명령문을 완성 
		 * 4.sql명령문 실행(select : executeQuery 
		 * 					insert,update,delete : executeUpdate) 
		 * 5.만약 executeQuery일경우 :sql결과(Result set)를 클래스로 변환
		 */
		String sql = "select deptno, deptname, floor from department where deptno= ?";
		try (Connection con = JdbcUtil.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, department.getDeptNo());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getDepartment(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertDepartment(Department department) {
		String sql = "insert into department values(?,?,?)";
		try (Connection con = JdbcUtil.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, department.getDeptNo());
			pstmt.setString(2, department.getDeptName());
			pstmt.setInt(3, department.getFloor());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateDepartment(Department department) {
		String sql = "update department set deptname = ? where deptno = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, department.getDeptName());
			pstmt.setInt(2, department.getDeptNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteDepartment(Department department) {
		String sql = "delete from department where deptno =?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, department.getDeptNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

}
