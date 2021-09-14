package java_erp_teacher.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import java_erp_teacher.dao.TradeDao;
import java_erp_teacher.dto.Trade;
import java_erp_teacher.util.JdbcUtil;

public class TradeDaoImpl implements TradeDao {
	
	public static final TradeDaoImpl instance = new TradeDaoImpl();
	
	public static TradeDaoImpl getInstance() {
		return instance;
	}
	public TradeDaoImpl() {
	}
	
	@Override
	public ArrayList<Trade> selectTradeByAll() {
		String sql ="select code, name, repr, number, address from trade";
		ArrayList<Trade> list= null;
		
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			list = new ArrayList<Trade>();
			while(rs.next()) {
				list.add(getDepartment(rs));
			}
		}catch(SQLException e) {
			
		}
		
		return null;
	}

	private Trade getDepartment(ResultSet rs) throws SQLException {
		int code = rs.getInt("code");
		String name = rs.getString("name");
		String repr = rs.getString("repr");
		String number = rs.getString("number");
		String address = rs.getString("address");
		Trade newTrade = new Trade(code,name,repr,number,address);
		return newTrade;
	}
	@Override
	public Trade selectTradeByNo(Trade trade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int intsertTrade(Trade trade) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateTrade(Trade trade) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteTrade(Trade trade) {
		// TODO Auto-generated method stub
		return 0;
	}

}
